package 多线程设计模式.静态内部类单例模式;

/**
 * 静态内部类实现单例
 *
 * @author zijian Wang
 */
public class StaticClassSingleton {

    public static class Singleton {
        private static final Singleton singleton = new Singleton();
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.singleton;
    }
}

