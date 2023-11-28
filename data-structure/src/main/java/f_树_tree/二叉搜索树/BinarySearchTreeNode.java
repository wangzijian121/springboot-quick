package f_树_tree.二叉搜索树;

/**
 * 二叉搜索树 ： 左子树中所有节点的值< 根节点的值 <  右子树中所有节点的值。任意节点的左、右子树也是二叉搜索树，即同样满足条件.
 *
 * @author zijian wang
 */
public class BinarySearchTreeNode {

    int value;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;


    public BinarySearchTreeNode(int value) {
        this.value = value;
    }


    /**
     * 查询节点
     *
     * @param binarySearchTreeNode
     * @param num
     */
    public static void findNode(BinarySearchTreeNode binarySearchTreeNode, int num) {

        if (binarySearchTreeNode.left == null && binarySearchTreeNode.right == null) {
            return;
        }
        while (binarySearchTreeNode != null) {
            System.out.print("\t " + binarySearchTreeNode.value);
            if (num > binarySearchTreeNode.value) {
                binarySearchTreeNode = binarySearchTreeNode.right;
            } else {
                binarySearchTreeNode = binarySearchTreeNode.left;
            }
            if (binarySearchTreeNode.value == num) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        BinarySearchTreeNode n1 = new BinarySearchTreeNode(1);
        BinarySearchTreeNode n2 = new BinarySearchTreeNode(2);
        BinarySearchTreeNode n3 = new BinarySearchTreeNode(3);
        BinarySearchTreeNode n4 = new BinarySearchTreeNode(4);
        BinarySearchTreeNode n5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode n6 = new BinarySearchTreeNode(6);
        BinarySearchTreeNode n7 = new BinarySearchTreeNode(7);


        /**
         *         3
         *      /    \
         *     2      4
         *   /          \
         * 1             6
         *              / \
         *            5    7
         * 思路：前序记录顺序： 中间节点->左节点->右节点
         */

        n3.left = n2;
        n3.right = n4;

        n2.left = n1;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        //寻找节点值为5 输出路径
        findNode(n3, 5);

    }
}
