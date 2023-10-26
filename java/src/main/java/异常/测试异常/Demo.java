package 异常.测试异常;

/**
 * 测试异常报错
 * @author zijian Wang
 */
public class Demo {
    public static void main(String[] args) {

        try {
            int num = Integer.parseInt("wangzijian");
            System.out.println(num);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("error!!");
        }
    }
}
