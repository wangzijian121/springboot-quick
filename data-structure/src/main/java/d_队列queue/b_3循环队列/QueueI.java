package d_队列queue.b_3循环队列;


/**
 * 队列接口
 *
 * @author zijian Wang
 */
public interface QueueI<E> {

    /**
     * 插入元素
     *
     * @param e
     * @return e
     */
    E add(E e);

    /**
     * 消费队列
     *
     * @return
     */
    E consume();

    /**
     * 清空队列
     *
     * @return
     */
    void removeAll();

    /**
     * 查看队列
     *
     * @return
     */
    void show();

    /**
     * 判断队列是否满
     *
     * @return
     */
    boolean isFull();
}
