package d_队列queue.b_4双向队列deque.链表实现;

/**
 * 双向队列 double-ended queue
 *
 * @author zijian Wang
 */
public class MyDeque {

    private DeLinkedNode head;
    private DeLinkedNode tail;
    private int size;


    public void pushFirst(int num) {

        DeLinkedNode deLinkedNode = new DeLinkedNode(num);
        if (head == null) {
            head = tail = deLinkedNode;
        } else {
            //插入到头节点后，插入后为head
            deLinkedNode.next = head;
            head.prev = deLinkedNode;
            head = deLinkedNode;
        }
        size++;
    }

    public void pushLast(int num) {
        DeLinkedNode deLinkedNode = new DeLinkedNode(num);
        if (tail == null) {
            head = tail = deLinkedNode;
        } else {
            //插入到尾节点后，插入后为tail
            tail.next = deLinkedNode;
            deLinkedNode.prev = tail;
            tail = deLinkedNode;
        }
        size++;
    }

    public int popFirst() {
        if (head == null) {
            return -1;
        }
        int num = head.value;
        head = head.next;
        head.prev.next = null;
        head.prev = null;
        return num;
    }

    public int popLast() {
        if (tail == null) {
            return -1;
        }
        int num = tail.value;
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        return num;
    }

    public int peekFirst() {
        return (head == null) ? -1 : head.value;
    }

    public int peekLast() {
        return (tail == null) ? -1 : tail.value;
    }

    private void print() {
        DeLinkedNode indexNode = head;
        while (indexNode != null) {
            System.out.print(indexNode.value + "\t");
            indexNode = indexNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyDeque myDeque = new MyDeque();

        myDeque.pushFirst(1);
        myDeque.pushFirst(2);
        myDeque.pushFirst(3);
        myDeque.pushFirst(4);
        myDeque.pushFirst(5);
        myDeque.print();

        System.out.println("popFirst 删除后");
        myDeque.popFirst();
        myDeque.print();

        System.out.println("popLast 删除后");
        myDeque.popLast();
        myDeque.print();

        System.out.println("输出前后节点值 ：");
        System.out.println(myDeque.peekFirst());
        System.out.println(myDeque.peekLast());

    }
}
