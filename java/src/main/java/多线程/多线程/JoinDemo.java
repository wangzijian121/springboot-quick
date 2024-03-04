package 多线程.多线程;

import java.util.concurrent.TimeUnit;

/**
 * join demo
 *
 * @author zijian Wang
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        thread.start();
        thread.join(0);
        System.out.println("执行结束");
    }
}
