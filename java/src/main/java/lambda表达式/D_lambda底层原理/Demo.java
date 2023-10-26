package lambda表达式.D_lambda底层原理;

import java.lang.invoke.LambdaMetafactory;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        list.forEach((num)-> System.out.println(num));
        list.forEach(System.out::println);
//        list.forEach((Consumer<? super Integer>) LambdaMetafactory.metafactory());
        //
    }
}
