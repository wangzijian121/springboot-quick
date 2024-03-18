package 多线程_生产者_消费者模式;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zijian Wang
 */
@Slf4j(topic = "c.MessageQueue")
public class MessageQueue {

    private final static LinkedList<Message> list = new LinkedList<>();
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 消费者调用get获取Message
     *
     * @return
     */
    public Message get() throws InterruptedException {
        synchronized (list) {
            if (list.isEmpty()) {
                log.info("队列为空，等待生产中...");
                list.wait();
            }
            Message message = list.removeFirst();
            list.notifyAll();
            return message;
        }
    }

    /**
     * 生产者调用put写入Message
     */
    public void put(Message message) throws InterruptedException {
        synchronized (list) {
            if (list.size() == capacity) {
                log.info("队列满了，等待消费中...");
                list.wait();
            }
            log.info("放入队列来自生产者：" + message.getId() + " 数据：" + message.getValue());
            list.addLast(message);
            list.notifyAll();
        }
    }
}
