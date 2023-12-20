package f_树_tree.堆;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 堆
 *
 * @author zijian Wang
 */
public class Heap {


    int[] nums = null;

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
        return (i - 1) / 2; // 向下整除
    }

    /**
     *
     */
    public static void push(int num) {

    }

    /**
     * 堆化
     *
     * @param heap
     */
    public static Heap siftUp(Heap heap) {

        int []  nums = heap.getNums();
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

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2, 10};
        Heap heap = new Heap(nums);
        System.out.println(Arrays.toString(siftUp(heap).getNums()));
    }
}
