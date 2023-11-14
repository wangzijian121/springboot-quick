package d_手写链表;

import java.util.List;

/**
 * @author zijian Wang
 */
public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int x) {
        this.value = x;
    }

    public static void insert(ListNode leftNode, ListNode node) {
        ListNode rightNode = leftNode.next;
        node.next = rightNode;
        leftNode.next = node;
    }

    public static void delete(ListNode node) {
        //最后的节点防止空指针
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    public static int get(ListNode head, int length) {
        int index = 0;

        while (true) {
            if (length == index) {
                return head.value;
            }
            //最后的节点防止空指针
            if (head.next != null) {
                head = head.next;
                index++;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        /**构建引用指向*/
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        System.out.println("原始数据：");
        print(n0);
        System.out.println("\n在n2 后插入n4");
        ListNode n4 = new ListNode(4);
        ListNode.insert(n2, n4);
        print(n0);
        ListNode.delete(n2);
        System.out.println("\n删除n2后面的节点：");
        print(n0);
        //get
        System.out.println("\n获取第2个node 的值");
        System.out.println(ListNode.get(n0, 2));
    }

    private static void print(ListNode headNode) {
        while (headNode != null) {
            System.out.print(headNode.value + "\t");
            headNode = headNode.next;
        }
    }
}