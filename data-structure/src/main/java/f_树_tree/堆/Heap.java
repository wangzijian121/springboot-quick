package f_树_tree.堆;

import java.util.Arrays;

/**
 * 堆
 *
 * @author zijian Wang
 */
public class Heap {

    private int[] nums;

    public Heap(int[] nums) {
        this.nums = nums;
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    /**
     * 获取左子节点索引
     *
     * @param i
     * @return
     */
    int left(int i) {
        return 2 * i + 1;
    }

    /**
     * 获取右子节点索引
     *
     * @param i
     * @return
     */
    int right(int i) {
        return 2 * i + 2;
    }

    /**
     * 获取父节点索引
     *
     * @param i
     * @return
     */
    int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 入堆
     */
    public void push(int num) {

        int[] newNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        newNums[newNums.length - 1] = num;
        nums = newNums;
    }

    /**
     * 出堆
     */
    public int pull() {

        int[] numsNew = new int[nums.length - 1];
        int pullNum = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            numsNew[0] = nums[nums.length - 1];
            numsNew[i] = nums[i];
        }

        nums = numsNew;
        return pullNum;
    }

    public int getTop() {
        return nums[0];
    }

    /**
     * 堆化：底->顶
     *
     * @param heap
     */
    public Heap siftUp(Heap heap) {

        int[] nums = heap.getNums();
        //插入点索引
        int i = nums.length - 1;
        //父节点索引
        int parentIndex;

        while (true) {
            parentIndex = heap.parent(i);

            if (i == 0 || nums[i] < nums[parentIndex]) {
                break;
            }
            System.out.println(i + "-" + parentIndex);
            System.out.println("交换:" + nums[i] + "-" + nums[parentIndex]);
            //交换
            int temp = nums[i];
            nums[i] = nums[parentIndex];
            nums[parentIndex] = temp;
            i = parentIndex;

            heap.setNums(nums);
        }
        return heap;
    }

    /**
     * 堆化：顶->底
     */
    public void siftDown() {

        int[] nums = this.getNums();
        //插入点索引
        int i = 0;
        //左子节点
        int left;
        //右子节点
        int right;

        while (true) {

            left = this.left(i);
            right = this.right(i);

            if ((left > nums.length && right > nums.length)
                    || (nums[i] > nums[left] && nums[i] > nums[right])) {
                break;
            }

            if (nums[i] < nums[left] && nums[left] > nums[right]) {
                //交换 右
                System.out.println("交换：" + i + "---" + left);
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i = left;
            } else {
                //交换 左
                System.out.println("交换：" + i + "---" + right);
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                i = right;
            }
            this.setNums(nums);
        }
    }

    public static void main(String[] args) {
        //入堆-向上堆化
   /*     int[] nums = new int[]{9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2};
        Heap heap = new Heap(nums);
        heap.push(666);
        System.out.println(Arrays.toString(heap.siftUp(heap).getNums()));
        //堆顶
        System.out.println(heap.getTop());*/

        //出堆-向下堆化
        int[] nums = new int[]{9, 8, 7, 6, 7, 6, 2, 1, 4, 3, 6, 2, 5};
        Heap heap = new Heap(nums);
        System.out.println(Arrays.toString(heap.getNums()));
        heap.pull();
        heap.siftDown();
        System.out.println(Arrays.toString(heap.getNums()));
        System.out.println(heap.getTop());

    }
}
