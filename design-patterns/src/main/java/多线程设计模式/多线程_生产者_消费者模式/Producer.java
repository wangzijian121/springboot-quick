package 多线程设计模式.多线程_生产者_消费者模式;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author zijian Wang
 */
@Slf4j(topic = "c.Producer")
public class Producer extends Thread {

    private int id;
    private final MessageQueue queue;

    public Producer(int id, MessageQueue queue) {
        this.id = id;
        this.queue = queue;
        log.info("初始化生产者：" + id);
    }

    @Override
    public void run() {
        produce();
    }

    /**
     * 生成数据
     */
    public void produce() {
        IntStream.range(1, 21).forEach(x -> {
            Random random = new Random();
            int randomNum = random.nextInt(9999);
            try {
                queue.put(new Message(id, String.valueOf(randomNum)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
