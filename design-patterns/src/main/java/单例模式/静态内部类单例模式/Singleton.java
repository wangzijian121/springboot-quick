package 单例模式.静态内部类单例模式;

/**
 * 静态内部类实现单例
 *
 * @author zijian Wang
 */
public class Singleton {

    /**
     * 需要单例的对象
     */
    public static class SingletonInner {
        private static final SingletonInner singleton = new SingletonInner();
    }

    public static void main(String[] args) {
        SingletonInner instance = SingletonInner.singleton;
    }
}

