package 多线程.java并发编程.a_创建线程;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用Thread 创建线程
 *
 * @author Administrator
 */
@Slf4j(topic = "c.CreateThreadUsedThreadClass")
public class CreateThreadUsedThreadClass {

    public static void main(String[] args) {
        log.debug("main-wangzijian");
        //创建线程对象
        Thread t = new Thread() {
            @Override
            public void run() {
                log.debug("wangzijian");
            }
        };
        t.setName("我的线程");
        //运行线程
        t.start();
    }
}
