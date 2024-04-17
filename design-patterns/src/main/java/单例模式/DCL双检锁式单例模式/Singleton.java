package 单例模式.DCL双检锁式单例模式;

/**
 * DCL 双重检查锁
 */
public final class Singleton {

    private final static Object lock = new Object();
    private static volatile Singleton singleton = null;

    public static Singleton getInstance() {
        /** 这个判断是为了判断doubleCheckLockSingleton 对象是是否已经初始化过*/
        if (singleton == null) {
            /**t2 */
            synchronized (lock) {
                /** 这个判空是为了在t1 创建对象后，将等待队列中的t2 过滤掉。*/
                if (singleton == null) {
                    /**t1 */
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
