package 多线程设计模式.Balking犹豫模式;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 犹豫模式：用在一个线程发现另一个线程或本线程已经做了某一件相同的事，那么本线程就无需再做
 * 了，直接结束返回
 * 🤨思路  使用volatile 作为是否执行过的标志位。
 *
 * @author zijian  Wang
 */
@Slf4j(topic = "c.BalkingDemo")
public class BalkingDemo {
    private static volatile Boolean MARK = false;

    public void createThread() {
        if (MARK) {
            log.info("已经创建过了！");
        } else {
            ThreadUnit threadUnit = new ThreadUnit();
            threadUnit.start();
            MARK = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BalkingDemo balkingDemo = new BalkingDemo();
        for (; ; ) {
            balkingDemo.createThread();
            TimeUnit.SECONDS.sleep(2);
        }
    }
}

@Slf4j(topic = "c.ThreadUnit")
class ThreadUnit extends Thread {
    @Override
    public void run() {
        for (; ; ) {
            log.info("当前线程：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

