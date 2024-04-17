package 单例模式.DCL双检锁式单例模式;

/**
 * DCL 双重检查锁
 */
public final class DoubleCheckLockSingleton {

    private final static Object lock = new Object();
    private static volatile  DoubleCheckLockSingleton doubleCheckLockSingleton = null;

    public static DoubleCheckLockSingleton getInstance() {
        if (doubleCheckLockSingleton == null) {
            synchronized (lock) {
                if (doubleCheckLockSingleton == null) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }

    public static void main(String[] args) {
        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
    }
}
