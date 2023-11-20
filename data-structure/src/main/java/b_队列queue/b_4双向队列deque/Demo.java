package b_队列queue.b_4双向队列deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zijian Wang
 */
public class Demo {
    public static void main(String[] args) {

        System.out.println("----使用数组---");
        //使用数组实现的双向队列
        Deque d = new ArrayDeque();

        d.add(1);
        d.add(2);
        d.add(3);
        System.out.println(d);
        d.addFirst(0);
        System.out.println(d);
        d.addLast(4);
        System.out.println(d);

        System.out.println("----使用链表---");
        Deque dequeLinked = new LinkedList();
        dequeLinked.add(1);
        dequeLinked.add(2);
        dequeLinked.add(3);
        System.out.println(dequeLinked);
        dequeLinked.addFirst(0);
        System.out.println(dequeLinked);
        dequeLinked.addLast(4);
        System.out.println(dequeLinked);

    }
}
