package 多线程设计模式.多线程懒汉式单例模式;

/***
 * 懒汉式单例：添加了synchronized  解决了多线程问题，但是会使访问性能降低。
 * @author zijian Wang
 */
public final class Singleton {

    private static Singleton singleton = null;

    public Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        //... 优化
    }
}
