package b_手写队列;

/**
 * 使用数组实现 先进先出FIFO 队列
 * 1.插入时：尾指针需要小于队列大小
 *
 * @author zijian Wang
 */
public class ArrayQueue<E> implements QueueI<E> {


    private Object[] arr;
    private int header;
    private int tail;

    public ArrayQueue(int size) {
        this.arr = new Object[size];
        this.header = 0;
        this.tail = 0;
    }

    @Override
    public E add(E e) {
        //判断是否满
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[tail] = e;
        tail++;
        return e;
    }

    @Override
    public E consume() {
        E o = (E) arr[header];
        arr[header] = null;
        header++;
        return o;
    }

    @Override
    public void removeAll() {
        for (int i = header; i <= tail - 1; i++) {
            arr[i] = null;
        }
        header = 0;
        tail = 0;
    }

    @Override
    public E[] show() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return (E[]) arr;
    }

    public boolean isFull() {
        return tail > arr.length - 1;
    }
}
