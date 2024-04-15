package 多线程设计模式.保护性暂停模式;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2个线程，
 * 一个获取资源，获取资源后传递给缓冲区
 * 一个线程从缓冲区中获取数据
 * <p>
 * 消费者超时时间
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.GuardedObjectUsedCache")
public class GuardedObjectUsedCache {

    private static final Object lock = new Object();
    private static int clientId = 0;
    /**
     * 缓冲区
     */
    private static final Map<Integer, Object> CACHE_MAP = new Hashtable();


    public String get(int id) throws InterruptedException {
        long timeout = 20000;
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            long passedTime = 0;
            while (CACHE_MAP.get(id).toString() == "") {
                log.info("检测结果o..." + CACHE_MAP.get(id).toString());

                //自旋获取数据
                if (passedTime > timeout) {
                    log.error("超时！不等了！");
                    CACHE_MAP.remove(id);
                    break;
                }
                //考虑到虚假唤醒的情况，虚假唤醒后需要等待(timeout - passedTime)时间
                lock.wait(timeout - passedTime);
                passedTime = System.currentTimeMillis() - startTime;
            }
            String o = CACHE_MAP.get(id).toString();
            CACHE_MAP.remove(id);
            return o;
        }
    }


    public String createResource(int id, String string) {
        synchronized (lock) {
            CACHE_MAP.put(id, string);
            log.info(CACHE_MAP.toString());
            lock.notifyAll();
        }
        return string;
    }

    public boolean register(int id) {

        if (CACHE_MAP.keySet().contains(id)) {
            log.error("生成Waiter错误");
            return false;
        } else {
            CACHE_MAP.put(id, "");
            return true;
        }
    }

    public synchronized int generateId() {
        return clientId++;
    }


    public static void main(String[] args) {

        //等待者
        IntStream.range(1, 10).forEach(x -> {
            GuardedObjectUsedCache guardedObject = new GuardedObjectUsedCache();
            int id = guardedObject.generateId();
            guardedObject.register(id);
            Waiter waiter = new Waiter(id);
            waiter.setName("等待者-" + id);
            waiter.start();
            Creater creater = new Creater(id);
            creater.setName("创建者-" + id);
            creater.start();
        });
        //监视器
        new Thread(() -> {
            for (; ; ) {
                log.info("【监视器】等待队列：" + CACHE_MAP.keySet()
                        .stream()
                        .collect(Collectors.toList()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (CACHE_MAP.size() == 0) {
                    break;
                }
            }
        }).start();
    }
}


@Slf4j(topic = "c.Waitter")
class Waiter extends Thread {

    private int id;

    public Waiter(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        try {
            GuardedObjectUsedCache guardedObjectV2 = new GuardedObjectUsedCache();
            String payload = guardedObjectV2.get(id);
            log.info(id + "获取到了资源：" + payload);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * 创建者
 *
 */
@Slf4j(topic = "c.Creater")
class Creater extends Thread {

    private int id;

    public Creater(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random random = new Random();
        GuardedObjectUsedCache guardedObjectUsedCache = new GuardedObjectUsedCache();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = random.nextInt(9999);
        guardedObjectUsedCache.createResource(id, String.valueOf(i));
    }
}

