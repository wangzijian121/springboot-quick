package 排序算法.h_计数排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 计数排序
 *
 * @author zijian Wang
 */
public class CountingSort {


    /**
     * 思路： 将，并统计次数。
     *
     * @param nums
     */
    public static void countSort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        ArrayList list = new ArrayList();
        for (Integer integer : map.keySet()) {
            int value = map.get(integer);
            for (int i = 0; i < value; i++) {
                list.add(integer);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {

        int[] nums = new int[]{5, 6, 2, 8, 1, 9, 12, 10, 3, 5, 8, 1, 2, 3, 15};
        countSort(nums);
        /**
         * 时间复杂度： O（n）
         * 空间复杂度：O(n)
         * 就地性：非就地排序
         * 稳定性：非稳定性
         *
         */
    }
}
