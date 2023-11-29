package f_树_tree.递归;

/**
 * 递归求阶乘
 * @author zijian Wang
 */
public class Demo {

    public static int jieCheng(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * jieCheng(n - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(jieCheng(0));
        System.out.println(jieCheng(5));
        System.out.println(jieCheng(10));
    }
}
