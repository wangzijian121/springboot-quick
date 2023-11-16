package b_队列queue.b_3循环队列;


import java.util.Arrays;

/**
 * 循环队列
 * <p>
 * 有效元素个数为= (maxsize+tail-header) % maxsize: 尾指针-首指针 ，由于出现复数的情况，加上maxsize后与maxsize取模。
 *
 * 为满时的条件：(tail+1)  % maxsize=header 尾指针模上maxsize。
 *
 * @author zijian Wang
 */
public class RingQueue<E> implements QueueI<E> {

    /**
     * 数组
     */
    private Object[] arr;
    /**
     * 头
     */
    private int header;
    /**
     * 尾
     */
    private int tail;
    /**
     * 最大值为，用户设定的size+1
     */
    private int maxSize;


    public RingQueue(int size) {
        /**数组中最后一个位置会给tail**/
        this.maxSize = size + 1;
        this.arr = new Object[maxSize];
        this.header = 0;
        this.tail = 0;
    }

    @Override
    public E add(E e) {
        if (isFull()) {
            throw new RuntimeException("循环队列已满！");
        }
        //赋值，当大于数组大小时，取模会重新从数组前端进行分配，避免越界。
        arr[tail % maxSize] = e;
        //赋值后tail指针的移动，向后移动，同理，取模是为了重新从数组前端进行分配，避免越界。
        tail = (tail + 1) % maxSize;
        return e;
    }

    @Override
    public E consume() {
        //拿出来一个变量
        Object o = arr[header % maxSize];
        //置空
        arr[header % maxSize] = null;
        if (theCountOfNotNull() == 0) {
            throw new RuntimeException("循环队列为空！");
        }
        //队首移动，同理，取模是为了重新从数组前端进行分配，避免越界。
        header = (header + 1) % maxSize;
        return (E) o;
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = null;
        }
        header = 0;
        tail = 0;
    }

    @Override
    public void show() {
        System.out.println("------------数据区↓↓↓------------");
        System.out.println("底层数组->" + Arrays.toString(arr));
        System.out.println("【header】" + header + "  【tail】" + tail);
        //非空元素的数量
        int count = theCountOfNotNull();
        for (int i = 0; i < count; i++) {
            //输出数组中的元素，同理，取模是为了重新从数组前端进行分配，避免越界。
            System.out.print(arr[(header + i) % maxSize] + "\t");
        }
        System.out.println();
        System.out.println("-----------数据区↑↑↑------------");
    }

    @Override
    public boolean isFull() {
        //满队列条件
        boolean isFull = (tail + 1) % maxSize == header;
        return isFull;
    }

    private int theCountOfNotNull() {
        //有效元素的数量
        return (maxSize + tail - header) % maxSize;
    }
}
