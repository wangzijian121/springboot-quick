package 排序算法.i_基数排序;

import java.sql.SQLOutput;
import java.util.*;

/**
 * 基数排序（需要借助计数排序）
 *
 * @author zijian Wang
 */
public class RadixSort {

    /* 获取元素 num 的第 k 位，其中 exp = 10^(k-1) */
    static int digit(int num, int exp) {
        // 传入 exp 而非 k 可以避免在此重复执行昂贵的次方计算
        return (num / exp) % 10;
    }

    /* 计数排序（根据 nums 第 k 位排序） */
    static void countingSortDigit(int[] nums, int exp) {
        // 十进制的位范围为 0~9 ，因此需要长度为 10 的桶数组
        int[] counter = new int[10];
        int n = nums.length;
        // 统计 0~9 各数字的出现次数
        for (int i = 0; i < n; i++) {
            int d = digit(nums[i], exp); // 获取 nums[i] 第 k 位，记为 d
            counter[d]++;                // 统计数字 d 的出现次数
        }
        System.out.println(Arrays.toString(counter));

        // 求前缀和，将“出现个数”转换为“数组索引”
        /**
         * 当 i 等于 0 时，将 count[0] 个值为 0 的元素放入 nums 的索引范围 [index[0], index[1])。
         * 当 i 等于 1 时，将 count[1] 个值为 1 的元素放入 nums 的索引范围 [index[1], index[2])。
         * 当 i 等于 2 时，将 count[2] 个值为 2 的元素放入 nums 的索引范围 [index[2], index[3])。
         */
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }
            System.out.println(Arrays.toString(counter));
        // 倒序遍历，根据桶内统计结果，将各元素填入 res
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int d = digit(nums[i], exp);
            int j = counter[d] - 1; // 获取 d 在数组中的索引 j
            res[j] = nums[i];       // 将当前元素填入索引 j
            counter[d]--;           // 将 d 的数量减 1
        }
        // 使用结果覆盖原数组 nums
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    /* 基数排序 */
    static void radixSort(int[] nums) {
        // 获取数组的最大元素，用于判断最大位数
        int m = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > m) {
                m = num;
            }
        }
        // 按照从低位到高位的顺序遍历
        for (int exp = 1; exp <= m; exp *= 10)
        // 对数组元素的第 k 位执行计数排序
        // k = 1 -> exp = 1
        // k = 2 -> exp = 10
        // 即 exp = 10^(k-1)
        {
            countingSortDigit(nums, exp);
        }
    }


    public static void main(String[] args) {

        int[] nums = new int[]{230231202, 230231228, 230231207, 230231205,
                230231212, 230231209, 230231204, 230231222, 230231224, 230231217};
//        radixSort(Arrays.asList(nums));
        radixSort(nums);
        /**
         * 时间复杂度：O（n）
         * 空间复杂度：O（n+d)数组 res 和 counter 。
         * 稳定性： 依赖于计数排序的稳定性。
         * 就地性：非就地排序。
         *
         */
    }
}
