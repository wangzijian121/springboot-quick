package 排序算法.g_桶排序;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 桶排序
 *
 * @author zijian Wang
 */
public class BucketSort {

    /**
     * 1.将数组中的放在各个范围桶中。
     * 2.对桶中的元素进行排序。
     */
    public static int[] bucketSort(int[] nums) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        int k = nums.length / 2;
        //初始化2/n 个桶范围
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }
        for (int num : nums) {
            int index = num / 2;
            list.get(index).add(num);
        }
        System.out.println(list);
        //桶排序
        List<Integer> resList = list.stream()
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());

        int i = 0;
        for (int num : resList) {
            nums[i++] = num;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{4, 1, 3, 7, 6, 9, 2, 1, 6, 5, 1};
        System.out.println(Arrays.toString(bucketSort(nums)));
    }
}
