package 多线程.java并发编程.java共享模型_工具.自定义线程池;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义线程池
 *
 * @author zijian Wang
 */
public class ThreadPool<T> {

    /**
     * Worker集合
     */
    private Set<Worker> workers;
    /**
     * Task执行队列
     */
    private TaskBlockedQueue<Runnable> taskBlockedQueue;
    /**
     * Worker的数量
     */
    private int coreSize;

    public ThreadPool(int queueMaxSize, int coreSize) {
        workers = new HashSet<>(coreSize);
        this.taskBlockedQueue = new TaskBlockedQueue<>(queueMaxSize);
        this.coreSize = coreSize;
        new Thread(() -> scheduler()).start();
    }

    /**
     * 执行
     *
     * @param task
     */
    public void execute(Runnable task) {
        synchronized (this) {
            if (workers.size() < coreSize) {
                //创建worker
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            } else if (workers.size() >= coreSize) {
                //放入队列
                taskBlockedQueue.put(task);
            }
        }
    }

    public void scheduler() {
        System.out.println("启动调度器！");
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (Worker worker : workers) {
                if (!worker.haveTask()) {
                    Runnable task = taskBlockedQueue.get(100000);
                    worker.loadTask(task);
                    LockSupport.unpark(worker);
                }
            }
        }
    }
}

/**
 * task执行者
 *
 * @param <T>
 */
class Worker<T> extends Thread {
    private Runnable task;

    public Worker(Runnable task) {
        this.task = task;
    }

    public void loadTask(Runnable task) {
        this.task = task;
    }

    public boolean haveTask() {
        return task != null ? true : false;
    }

    @Override
    public void run() {
        while (haveTask()) {
            task.run();
            this.task = null;
            LockSupport.park();
        }
    }
}

/**
 * 任务阻塞队列（放入任务、消费执行任务）
 *
 * @param <T>
 */
@Slf4j(topic = "c.TaskBlockedQueue")
class TaskBlockedQueue<T> {

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionForGet = lock.newCondition();
    private Condition conditionForPut = lock.newCondition();
    private Deque<T> deque = new ArrayDeque();
    private DenyPolicy denyPolicy;
    private int maxSize;

    public TaskBlockedQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 从阻塞队列中消费task
     *
     * @return
     */
    public T get(long timeout) {
        T t = null;
        long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
        lock.lock();
        try {
            while (deque.isEmpty()) {
                long timeRemaining = conditionForGet.awaitNanos(nanos);
                if (timeRemaining <= 0L) {
                    log.error("get时间超时！");
                    return null;
                }
            }
            t = deque.pollLast();
            System.out.println("get");
            conditionForPut.signal();
        } catch (Exception e) {
            log.error("消费task失败！");
        } finally {
            lock.unlock();
        }
        return t;
    }

    /**
     * 将任务放进阻塞队列
     *
     * @param task
     */
    public void put(T task) {
        long nanos = TimeUnit.MILLISECONDS.toNanos(200000);
        lock.lock();
        try {
            while (isFull()) {
                long timeRemaining = conditionForPut.awaitNanos(nanos);
                if (timeRemaining <= 0L) {
                    log.error("拒绝策略-put超时！");
                    break;
                }
            }
            if (deque.size() <= maxSize) {
                log.info("成功put到队列🙋‍♂️");
                deque.push(task);
                conditionForGet.signal();
            } else {
                //拒绝策略：超时后停止
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public boolean isFull() {
        return deque.size() >= maxSize ? true : false;
    }

    public boolean isEmpty() {
        return deque.isEmpty() ? true : false;
    }
}