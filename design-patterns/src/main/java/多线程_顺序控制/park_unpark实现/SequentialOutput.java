package 多线程_顺序控制.park_unpark实现;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 使用park、 unpark控制先打印1 后打印2 反复执行
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.Demo")
public class SequentialOutput extends Thread {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                LockSupport.park();
                log.info("1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                log.info("2");
                LockSupport.unpark(thread1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
