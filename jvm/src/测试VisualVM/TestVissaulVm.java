package 测试VisualVM;

public class TestVissaulVm {
    private static final int _1MB = 1024 * 1024;


    public static void main(String[] args) throws InterruptedException {

    /*    for (int i = 0; i <= 500; i++) {
            byte[] b = new byte[_1MB];
            Thread.sleep(100);
            System.out.println(i);
        }*/
        byte[] b = new byte[_1MB * 200];
        test(b);
        Thread.sleep(999999);
    }

    public static void test(byte[] obj) throws InterruptedException {
        //test()
        Thread.sleep(999999);
    }
}
