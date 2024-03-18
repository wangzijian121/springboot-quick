package 多线程_保护性暂停模式;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.List;
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
@Slf4j(topic = "c.GuardedObject_V2")
public class GuardedObject_V2 {

    private static int clientId = 0;
    private static final Object lock = new Object();
    private static final Map<Integer, Object> cacheMap = new Hashtable();


    public String get(int id) throws InterruptedException {
//    System.out.println("超时时间：" + timeout + "毫秒");
        long timeout = 20000;
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            long passedTime = 0;
            while (cacheMap.get(id).toString() == "") {
                log.info("检测结果o..." + cacheMap.get(id).toString());

                //自旋获取数据
                if (passedTime > timeout) {
                    log.error("超时！不等了！");
                    cacheMap.remove(id);
                    break;
                }
                //考虑到虚假唤醒的情况，虚假唤醒后需要等待(timeout - passedTime)时间
                lock.wait(timeout - passedTime);
                passedTime = System.currentTimeMillis() - startTime;
            }
            String o = cacheMap.get(id).toString();
            cacheMap.remove(id);
            return o;
        }
    }


    public String createResource(int id, String string) {
        synchronized (lock) {
            cacheMap.put(id, string);
            log.info(cacheMap.toString());
            lock.notifyAll();
        }
        return string;
    }

    public boolean register(int id) {

        if (cacheMap.keySet().contains(id)) {
            log.error("生成Waiter错误");
            return false;
        } else {
            cacheMap.put(id, "");
            return true;
        }
    }

    public synchronized int generateId() {
        return clientId++;
    }


    public static void main(String[] args) {

        //等待者
        IntStream.range(1, 10).forEach(x -> {
            GuardedObject_V2 guardedObject = new GuardedObject_V2();
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
                log.info("【监视器】等待队列：" + cacheMap.keySet()
                        .stream()
                        .collect(Collectors.toList()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (cacheMap.size() == 0) {
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
            GuardedObject_V2 guardedObjectV2 = new GuardedObject_V2();
//            System.out.println("id：" + id + " 等待消息中...");
            String payload = guardedObjectV2.get(id);
            log.info(id + "获取到了资源：" + payload);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Slf4j(topic = "c.Creater")
class Creater extends Thread {

    private int id;

    public Creater(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random random = new Random();
        GuardedObject_V2 guardedObjectV2 = new GuardedObject_V2();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = random.nextInt(9999);
//        System.out.println("为" + i + "生成资源:" + i);
        guardedObjectV2.createResource(id, String.valueOf(i));
    }
}

