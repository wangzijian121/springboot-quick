package 排序算法.f_堆排序_heap_sort;

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
        siftUp();
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
        siftDown();
        System.out.println(Arrays.toString(nums));
        return pullNum;
    }

    public int getTop() {
        return nums[0];
    }

    /**
     * 堆化：底->顶
     */
    public void siftUp() {

        int[] nums = getNums();
        //插入点索引
        int i = nums.length - 1;
        //父节点索引
        int parentIndex;

        while (true) {
            parentIndex = parent(i);

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

            setNums(nums);
        }
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

            if ((left > nums.length-1 || right > nums.length-1)
                    || (nums[i] > nums[left] && nums[i] > nums[right])) {
                break;
            }

            if (nums[i] < nums[left] && nums[left] > nums[right]) {
                //交换 右
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i = left;
            } else {
                //交换 左
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                i = right;
            }
            this.setNums(nums);
        }
    }
}
