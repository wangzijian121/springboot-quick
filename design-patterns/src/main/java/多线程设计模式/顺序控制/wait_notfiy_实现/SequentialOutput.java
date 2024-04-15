package 多线程设计模式.顺序控制.wait_notfiy_实现;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 使用wait、notify 控制先打印1 后打印2 反复执行
 * 思路 使用对象锁的形式，依赖wait 和 notify 实现等待队列和waitSet中的 线程等待和唤醒。
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.Demo")
public class SequentialOutput {

    private final static SequentialOutput lock = new SequentialOutput();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        lock.notifyAll();
                        lock.wait();
                        log.info("1");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    log.info("2");
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
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
