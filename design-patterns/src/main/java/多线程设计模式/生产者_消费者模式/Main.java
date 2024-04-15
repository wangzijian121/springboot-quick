package 多线程设计模式.生产者_消费者模式;

import java.util.stream.IntStream;

/**
 * 消费者-生产者队列
 *
 *
 * @author zijian Wang
 */
public class Main {
    public static void main(String[] args)  {
        MessageQueue messageQueue = new MessageQueue(5);


        IntStream.range(1, 3).forEach(x -> {
            Producer producer = new Producer(x, messageQueue);
            producer.setName("生产者" + x);
            producer.start();
        });

        //消费者
        IntStream.range(1, 3).forEach(x -> {
            Consumer consumer = new Consumer(1, messageQueue);
            consumer.setName("消费者" + x);
            consumer.start();
        });
    }
}
