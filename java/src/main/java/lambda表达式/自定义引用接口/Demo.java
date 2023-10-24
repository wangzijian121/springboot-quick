package lambda表达式.自定义引用接口;

import lambda表达式.自定义引用接口.MyReference;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zijian Wang
 */
public class Demo {
    public static void main(String[] args) {

        Random random = new Random();
        Stream.generate(() -> random.nextInt(10))
                .limit(10)
                .sorted()
                .forEach(MyReference::getName);
    }
}