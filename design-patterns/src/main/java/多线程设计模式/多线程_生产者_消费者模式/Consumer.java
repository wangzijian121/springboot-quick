package 多线程设计模式.多线程_生产者_消费者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.Consumer")
public class Consumer extends Thread {

    private int id;
    private final MessageQueue queue;
    private int count;

    public Consumer(int id, MessageQueue messageQueue) {
        this.id = id;
        queue = messageQueue;
        log.info("初始化消费者：" + id);
    }

    @Override
    public void run() {
        get();
    }

    private void get() {
        for (; ; ) {
            try {
                Message message = queue.get();
                count++;
                log.info("消费到了：" + message.getValue() + "共消费到：" + count+"次！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
