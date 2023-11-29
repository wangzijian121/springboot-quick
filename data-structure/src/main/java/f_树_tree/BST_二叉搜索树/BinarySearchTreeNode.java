package f_树_tree.BST_二叉搜索树;

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

    public void setValue(int value) {
        this.value = value;
    }

    public String print() {
        return "BinarySearchTreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 查询节点
     *
     * @param binarySearchTreeNode
     * @param num
     */
    public static BinarySearchTreeNode findNode(BinarySearchTreeNode binarySearchTreeNode, int num) {

        if (binarySearchTreeNode.left == null && binarySearchTreeNode.right == null) {
            return null;
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
        return binarySearchTreeNode;
    }


    /**
     * 插入操作
     *
     * @param rootNode
     */
    public static void insert(BinarySearchTreeNode rootNode, BinarySearchTreeNode newNode) {

        int num = newNode.value;
        if (rootNode == null) {
            return;
        }
        System.out.print("\t" + rootNode.value);

        if (num < rootNode.value) {
            if (rootNode.left == null) {
                rootNode.left = newNode;
            } else {
                insert(rootNode.left, newNode);
            }
        }

        if (num >= rootNode.value) {
            if (rootNode.right == null) {
                rootNode.right = newNode;
            } else {
                insert(rootNode.right, newNode);
            }
        }
    }

    /**
     * 删除，3种情况：
     * 没有子节点：直接删除
     * 1个子节点：直接删除，连接到子节点。
     * 2个子节点：左节点最小、右节点最大值
     */
    public void delete(BinarySearchTreeNode rootNode, int num) {
        /**
         * 插入完成
         *         3
         *      /    \
         *     2      4
         *   /          \
         * 1             6
         *              / \
         *            5    7
         *           /
         *          4
         *           \
         *            4
         */

        BinarySearchTreeNode index = null;
        while (rootNode != null) {
            System.out.println("扫描的节点：" + rootNode.print());
            if (rootNode.value == num) {
                break;
            }
            index = rootNode;
            if (num < rootNode.value) {
                rootNode = rootNode.left;
            }
            if (num > rootNode.value) {
                rootNode = rootNode.right;
            }
        }
        System.out.println("索引节点：" + index.print());
        System.out.println("要删除节点：" + rootNode.print());

        int childCount = getChildCount(rootNode);
        switch (childCount) {
            case 0:
                //直接删除节点
                System.out.println("0个子节点");
                if (index.left.value == num) {
                    index.left = null;
                } else {
                    index.right = null;
                }
                break;
            case 1:
                System.out.println("1个子节点");
                //判断删除节点的子节点在左右
                BinarySearchTreeNode childNode = rootNode.left != null ? rootNode.left : rootNode.right;
                //直接将索引节点与子节点连接，不需要删除
                if (index.left == rootNode) {
                    index.left = childNode;
                } else {
                    index.right = childNode;
                }
                break;
            case 2:
                //寻找并递归删除【左节点最大或右节点最小】节点 nex、 并将nex值复制给要删除的节点
                //递归删除右子树的最小节点
                BinarySearchTreeNode minNode = deleteMinNode(rootNode.right);
                if (rootNode.right == minNode) {
                    rootNode.right = null;
                }
                rootNode.value = minNode.value;

                System.out.println("2个子节点");
                break;
            default:
                break;
        }
    }

    /**
     * 递归删除节点的最小值
     *
     * @param rootNode
     */
    public static BinarySearchTreeNode deleteMinNode(BinarySearchTreeNode rootNode) {

        rootNode.setValue(666);
/*        if (rootNode.left == null && rootNode.right == null) {
            return rootNode;
        }
        if (rootNode.left.left == null) {
            BinarySearchTreeNode minNode = rootNode.left;
            System.out.println("子树最小的节点：" + rootNode.left.print());
            rootNode.left = null;
            return minNode;
        } else {
            deleteMinNode(rootNode.left);
        }*/
        return null;
    }


    /**
     * 获取直接子节点数 枚举为：0，1，2
     *
     * @param binarySearchTreeNode
     * @return
     */
    private static int getChildCount(BinarySearchTreeNode binarySearchTreeNode) {
        int childCount = 0;
        if (binarySearchTreeNode.left != null) {
            childCount++;
        }
        if (binarySearchTreeNode.right != null) {
            childCount++;
        }
        return childCount;
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

        System.out.println("寻找节点5的路径:");

        System.out.println(findNode(n3, 5).print());

        System.out.println("\n插入节点,插入的路径:");
        BinarySearchTreeNode newNode = new BinarySearchTreeNode(4);
        //3	 4	6	5
        insert(n3, newNode);
        //再次插入，相同的值应该在相同值节点的右边。
        //3	4	6	5  4
        insert(n3, newNode);
        //4
        System.out.println("\n  n5节点的左子节点的值：" + n5.left.value);
        //4
        System.out.println("n5节点的左子节点的右子节点的值：" + n5.left.right.value);
        /**
         * 插入完成
         *         3
         *      /    \
         *     2      4
         *   /          \
         * 1             6
         *              / \
         *            5    7
         *           /
         *          4
         *           \
         *            4
         */
        System.out.println();
        n3.delete(n3, 6);
        System.out.println("检查是否删除，n4 的right的值变为7 ：" + n4.right.print());
        System.out.println("检查是否删除(删除后n6的值变为7)：" + n6.print());
        System.out.println("检查是否删除(删除后n6的值变为7，n6 的left还是5)：" + n6.left.print());

    }
}