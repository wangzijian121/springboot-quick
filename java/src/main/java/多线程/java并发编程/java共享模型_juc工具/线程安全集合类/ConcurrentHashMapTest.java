package 多线程.java并发编程.java共享模型_juc工具.线程安全集合类;

import utils.SleepUtils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author zijian Wang
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("count", 0);
        //10个线程分别对这个map中的countkey加1.
        IntStream.range(0, 10).forEach(x ->
                new Thread(() -> {
                    for (int i = 0; i < 100L; i++) {
                        concurrentHashMap.computeIfPresent("count", (key, val) -> (int) val + 1);
                    }
                }
                ).start());
        SleepUtils.sleep(1);

//        System.out.println(concurrentHashMap.get("count"));
        concurrentHashMap.forEachKey(3,x-> System.out.println(x));
        concurrentHashMap.forEachValue(3,x-> System.out.println(x));


    }
}
