public class Demo {
    private static String name111 = "WANGZIJIAN";


    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }

    private static class Wangzijian {
        private String name = "wangzijian";
    }


    static class Test {
        static Wangzijian staticWang = new Wangzijian();
        Wangzijian instanceWang = new Wangzijian();

        void foo() {
            Wangzijian localWang = new Wangzijian();

            System.out.println("----");
        }
    }

}

