package f_树_tree.BT_二叉树;

import java.util.*;

/**
 * 二叉树
 *
 * @author zijian Wang
 */
public class TreeNode {

    /**
     * 树节点值
     */
    int value;
    /**
     * 左节点
     */
    TreeNode left;
    /**
     * 右节点
     */
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }


    /**
     * 获取二叉树的节点数
     *
     * @param treeNode
     * @return
     */
    public static int getNum(TreeNode treeNode) {

        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }
        int leftCount = getNum(treeNode.left);
        int rightCount = getNum(treeNode.right);
        return leftCount + rightCount + 1;
    }

    /**
     * 广度优先遍历 breadth-first traversal BFS
     */
    public static List<Integer> breadthFirstTraversal(TreeNode rootNode) {
        /**
         *         1
         *      /    \
         *     2      3
         *   / \     / \
         * 4    5  6    7
         *
         * 思路：使用队列存储待遍历的子节点。
         * eg:遍历1 时，将2 3 放入queue ，在遍历2 时，将2的子节点放入queue。
         */
        Queue<TreeNode> queue = new LinkedList();
        queue.add(rootNode);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            //每次出队, 知道队列为空
            TreeNode treeNode = queue.poll();
            list.add(treeNode.value);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return list;
    }

    /**
     * 「深度优先遍历 depth-first traversal」 - 前序遍历
     *
     * @param rootNode
     */
    public static void preOrder(TreeNode rootNode) {
        /**
         *         1
         *      /    \
         *     2      3
         *   / \     / \
         * 4    5  6    7
         *
         * 思路：前序记录顺序： 中间节点->左节点->右节点
         */
        if (rootNode != null) {
            System.out.print("\t" + rootNode.value);
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    /**
     * 「深度优先遍历 depth-first traversal」- 中序遍历
     *
     * @param rootNode
     */
    public static void inOrder(TreeNode rootNode) {
        /**
         * 思路：前序记录顺序： 左节点->中间节点->右节点
         */
        if (rootNode != null) {
            inOrder(rootNode.left);
            System.out.print("\t" + rootNode.value);
            inOrder(rootNode.right);
        }
    }

    /**
     * 「深度优先遍历 depth-first traversal」- 后序遍历
     *
     * @param rootNode
     */
    public static void postOrder(TreeNode rootNode) {
        /**
         * 思路：前序记录顺序： 右节点->中间节点->左节点
         */

        if (rootNode != null) {
            postOrder(rootNode.left);
            postOrder(rootNode.right);
            System.out.print("\t" + rootNode.value);
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        // 构建引用指向（即指针）
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        /**
         *       1
         *    /     \
         *   2       3
         *  / \     / \
         *4    5  6    7
         */
        System.out.println("二叉树节点数：" + getNum(n1));
        //广度优先遍历 BFS
        System.out.println("BFS:" + breadthFirstTraversal(n1));
        //前序遍历
        System.out.println("前序遍历");
        preOrder(n1);

        //中序遍历
        System.out.println();
        System.out.println("中序遍历");
        inOrder(n1);

        //后序遍历
        System.out.println();
        System.out.println("后序遍历");
        postOrder(n1);
    }
}