package b_队列queue.b_4双向队列deque;

/**
 * double-ended Linked List
 *
 * @author zijian Wang
 */
public class DeLinkedNode {

    int value;
    DeLinkedNode next;
    DeLinkedNode prev;

    public DeLinkedNode(int value) {
        this.value = value;
        next = prev = null;
    }

    public void insert(DeLinkedNode newNode) {

        //插入到调用的节点后面的节点，暂存为node
        DeLinkedNode node = this.next;
        this.next = newNode;
        newNode.next = node;
        newNode.prev = this;
    }

    public static void delete(DeLinkedNode deleteNode) {

        //将要删除的节点暂存为prevNode 、nextNode
        DeLinkedNode prevNode = deleteNode.prev;
        DeLinkedNode nextNode = deleteNode.next;

        //关联前后的节点
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }


    private static void print(DeLinkedNode headNode) {
        while (headNode != null) {
            System.out.print(headNode.value + "\t");
            headNode = headNode.next;
        }
    }
}
