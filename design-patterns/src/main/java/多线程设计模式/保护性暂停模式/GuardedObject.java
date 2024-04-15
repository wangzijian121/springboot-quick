package 多线程设计模式.保护性暂停模式;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2个线程，一个获取资源，获取资源后传递给另一个线程
 *
 * 消费者超时时间
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.GuardedObject")
public class GuardedObject {

    private static final Object lock = new Object();
    private Object response = null;

    public void get() throws InterruptedException {
        long timeout = 3000;
        System.out.println("超时时间："+timeout+"毫秒");
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null) {
                if (passedTime > timeout) {
                    log.error("超时！不等了！");
                    break;
                }
                log.info("等待资源....");
                //考虑到虚假唤醒的情况，虚假唤醒后需要等待(timeout - passedTime)时间
                lock.wait(timeout - passedTime);
                passedTime = System.currentTimeMillis() - startTime;
            }
            if (response != null) {
                log.info(response.toString());
            }
        }
    }

    public List<Integer> makeOver(List<Integer> list) {
        synchronized (lock) {
            this.response = list;
            lock.notifyAll();
            log.info("资源生成完成！");
        }
        return list;
    }


    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        //获取资源
        Thread thread1 = new Thread(() -> {
            List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                    .collect(Collectors.toList());
            log.info("生成资源中.....");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            guardedObject.makeOver(list);
        });
        thread1.start();

        //接收资源并处理
        Thread thread2 = new Thread(() -> {
            try {
                guardedObject.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();
    }
}
