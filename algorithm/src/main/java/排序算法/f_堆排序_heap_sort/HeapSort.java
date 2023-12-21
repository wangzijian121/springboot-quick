package 排序算法.f_堆排序_heap_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 堆排序
 *
 * @author zijian Wang
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 1, 7, 6, 4, 2, 10};
        Heap heap = new Heap(new int[]{});
        for (int i = 0; i < nums.length; i++) {
            heap.push(nums[i]);
        }
        System.out.println("建堆后数组：" + Arrays.toString(heap.getNums()));
        int len = heap.getNums().length;
        List list = new ArrayList();
        for (int i = 0; i < len; i++) {
            list.add(heap.pull());
        }
        System.out.println(list);
    }
    /**
     * 时间复杂度:O(nlogn)
     * 空间复杂度：O(1)
     * 自适应： 非自适应
     * 稳定性：非稳定排序
     * 原地性：原地排序
     *
     */
}
