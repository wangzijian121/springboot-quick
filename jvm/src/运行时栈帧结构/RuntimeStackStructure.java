package 运行时栈帧结构;

/**
 * VM Options：-Xmx100M -Xms100M -Xmn40M -Xss1M -Xloggc:./jvm/src/运行时栈帧结构/RuntimeStackStructure-gc.log
 * VM Options：-Xmx100M -Xms100M -Xmn40M -Xss1M -Xmx300M -Xms300M -Xmn10M -Xss1M -verbose:gc  -XX:+PrintGCDetails
 */
public class RuntimeStackStructure {
    /**
     * 不会回收
     * @param args
     * @throws InterruptedException
     */
/*    public static void main(String[] args) throws InterruptedException {
        //分配60M内存
        {
            byte[] bytes = new byte[60 * 1024 * 1024];
        }
        System.gc();
    }*/


    /**
     * 不会回收
     *
     * @param args
     * @throws InterruptedException
     */
/*    public static void main(String[] args) throws InterruptedException {
        //分配60M内存
        {
            byte[] bytes1 = new byte[60 * 1024 * 1024];
        }
        //使用该方法替换bytes1 的变量槽
        int a = 0;
        System.gc();
        byte[] arr = new byte[60 * 1024 * 1024];
        System.gc();
    }*/
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println(b >> 1);
    }
}