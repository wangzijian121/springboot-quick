package 多线程.java并发编程.java共享模型_工具.自定义线程池;

/**
 * 针对阻塞队列的 拒绝策略
 */
@FunctionalInterface
public interface DenyPolicy {
    void load();
}
