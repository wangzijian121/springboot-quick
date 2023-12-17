package 搜索算法.二叉查找;

/**
 * 问题：给定一个长度为N 的数组 nums ，元素按从小到大的顺序排列且不重复。请查找并返回元素 target 在该数组中的索引。
 * 思路
 * 1.开头结尾为i、j，判断 i、j的中间位置 m, 判断寻找的值大于还是小于中间值。
 * 2.如果小于m m变为j
 * 3.如果大于m m变为i
 * 4.重复1
 *
 * @author zjian Wang
 */
public class BinarySearch {
    final static int ARR_LEN = 100000;

    public static int binarySearch(int num) {
        //初始化长度为ARR_LEN的数组
        int[] arr = new int[ARR_LEN];
        for (int i = 0; i < ARR_LEN; i++) {
            arr[i] = i + 1;
        }
        //开头
        int i = 0;
        //结尾
        int j = arr.length - 1;
        int count = 0;
        while (true) {
            if (i == j || num > j || num < i) {
                System.out.println("没有这个值！");
                return -1;
            }
            int index = i + (j - i) / 2;
            int middleValue = arr[index];
            System.out.println("i:" + i + " j:" + j + " middleValue:" + middleValue);
            count++;
            //middleValue 等于要寻找的值num
            if (middleValue == num) {
                System.out.println("共查找：" + count + "次,索引为：" + index);
                return middleValue;
            }
            //分割范围
            if (num > middleValue) {
                i = middleValue - 1;
            } else {
                j = middleValue - 1;
            }
        }
    }

    public static void main(String[] args) {
        binarySearch(12);
        /**
         * ARR_LEN=100 时，查询5次。
         * ARR_LEN=1000 时，查询9次。
         * ARR_LEN=10000 时，查询12次。
         * ARR_LEN=100000 时，查询17次。
         * ARR_LEN=1000000 时，查询18次。
         * ARR_LEN=10000000 时，查询22次。
         * ARR_LEN=100000000 时，查询23次。
         * 可知 二分查找的时间复杂度的为O(logn)
         */
    }
}
