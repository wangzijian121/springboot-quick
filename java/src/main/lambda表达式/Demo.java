package lambda表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        Random random = new Random();
        List<String> list = new ArrayList<>();
        list.add(random.nextInt(10) + "");
        list.add(random.nextInt(10) + "");
        list.add(random.nextInt(10) + "");

        //使用常规for输出
/*        for (String str : list) {
            System.out.println(str);
        }*/
//        使用lambda输出
//        list.forEach(str -> System.out.println(str));

        System.out.println();

        Stream<String> stream = list.stream();
        Stream<String> streamSliceOps = stream.limit(2);
        System.out.println("引用管道对象头：" + stream);
        System.out.println("切片操作：" + streamSliceOps);
        System.out.println("想要的输出：" + list.stream().limit(2).collect(Collectors.toList()));
    }
}
