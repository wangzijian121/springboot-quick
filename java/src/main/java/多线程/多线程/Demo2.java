package 多线程.多线程;

/**
 * @author zijian Wang
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {


        Demo2 demo2 = new Demo2();
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行打断！");
            demo2.notify();
        }, "打断线程");

        Thread thread2 = new Thread(() -> {

            try {
                demo2.myWait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "wait进程");
        thread1.start();
        thread2.start();
    }


    /**
     * 必须持有对象锁，此处使用的是Demo2的内置锁
     *
     * @throws InterruptedException
     */
    public synchronized void myWait() throws InterruptedException {
        wait();
        System.out.println("被打断！");
    }
}
