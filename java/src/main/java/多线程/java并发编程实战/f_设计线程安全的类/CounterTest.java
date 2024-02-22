package 多线程.java并发编程实战.f_设计线程安全的类;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class CounterTest {

    @RepeatedTest(10)
    public void testIncrement() throws InterruptedException {
        CounterUsedSynchronized counterUsedAtomic = new CounterUsedSynchronized();
        Thread t1 = new Thread(() -> {
            IntStream.range(0, 1000).forEach(x -> {
                counterUsedAtomic.increment();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(0, 1000).forEach(x -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counterUsedAtomic.increment();
            });
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertEquals(2000, counterUsedAtomic.getValue());
    }
}