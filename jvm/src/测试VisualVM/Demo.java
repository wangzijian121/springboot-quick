package 测试VisualVM;

public class Demo {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int i = 0;
        for (; ; ) {
            //4 byte
            int a = 1;
            System.out.println(++i + "次");
        }
    }
}
