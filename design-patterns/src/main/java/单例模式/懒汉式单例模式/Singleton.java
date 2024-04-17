package 单例模式.懒汉式单例模式;

/***
 * 懒汉式单例：解决了饿汉式的空间浪费的问题，但是会有多线程的问题。
 * @author  zijian Wang
 */
public final class Singleton {

    private static Singleton singleton = null;

    public Singleton() {
    }

    public static Singleton getInstance() {
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
