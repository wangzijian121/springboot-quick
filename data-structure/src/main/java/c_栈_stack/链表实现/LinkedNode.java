package c_栈_stack.链表实现;

/**
 * @author zijian Wang
 */
public class LinkedNode {

    private int value;
    private LinkedNode next;

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public LinkedNode(int x) {
        this.value = x;
    }

    public static void insert(LinkedNode leftNode, LinkedNode node) {
        LinkedNode rightNode = leftNode.next;
        node.next = rightNode;
        leftNode.next = node;
    }

    public static void delete(LinkedNode node) {
        //最后的节点防止空指针
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    public static int get(LinkedNode head, int length) {
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
        LinkedNode n0 = new LinkedNode(0);
        LinkedNode n1 = new LinkedNode(1);
        LinkedNode n2 = new LinkedNode(2);
        LinkedNode n3 = new LinkedNode(3);
        /**构建引用指向*/
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        System.out.println("原始数据：");
        print(n0);
        System.out.println("\n在n2 后插入n4");
        LinkedNode n4 = new LinkedNode(4);
        LinkedNode.insert(n2, n4);
        print(n0);
        LinkedNode.delete(n2);
        System.out.println("\n删除n2后面的节点：");
        print(n0);
        //get
        System.out.println("\n获取第2个node 的值");
        System.out.println(LinkedNode.get(n0, 2));
    }

    private static void print(LinkedNode headNode) {
        while (headNode != null) {
            System.out.print(headNode.value + "\t");
            headNode = headNode.next;
        }
    }
}