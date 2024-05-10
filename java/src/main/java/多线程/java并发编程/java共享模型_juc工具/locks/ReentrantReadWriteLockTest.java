package 多线程.java并发编程.java共享模型_juc工具.locks;

import utils.SleepUtils;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

import static 多线程.java并发编程.java共享模型_juc工具.locks.ReentrantReadWriteLockTest.lock;

/**
 * @author zijian Wang
 */
public class ReentrantReadWriteLockTest {
    final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static int num;

    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger integer = new AtomicInteger(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                r -> {
                    final Thread thread = new Thread(r);
                    thread.setName("wangzijian-" + integer.getAndIncrement());
                    return thread;
                }, new ThreadPoolExecutor.DiscardOldestPolicy());
        IntStream.range(0, 10).forEach(x -> threadPoolExecutor.execute(new Task()));
        threadPoolExecutor.shutdown();
    }
}

class Task implements Runnable {
    final static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    final static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public int printTask() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "获取读锁！"+ LocalTime.now());
        try {
            return ReentrantReadWriteLockTest.num;
        } finally {
            readLock.unlock();
        }
    }

    public void addTask() {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "获取写锁！"+ LocalTime.now());
        try {
            for (int i = 0; i < 100; i++) {
                ReentrantReadWriteLockTest.num++;
            }
            SleepUtils.sleep(1);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void run() {
        System.out.println("do...");
        addTask();
        System.out.println("结果：" + printTask());
    }
}



