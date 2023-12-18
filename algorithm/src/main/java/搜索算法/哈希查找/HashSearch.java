package 搜索算法.哈希查找;

import utils.RandomArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 问题：给定一个整数数组 nums 和一个目标元素 target ，
 * 请在数组中搜索“和”为 target 的两个元素，并返回它们的数组索引。
 *
 * @author zijian Wang
 */
public class HashSearch {


    private final static int TARGET = 9;

    /**
     * 使用线性查找双重循环判断
     *
     * @return
     */
    public static void LinearSearch() {

        int[] arr = RandomArray.getRandomArray(10);
        System.out.println("生成的数组:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == TARGET) {
                    System.out.println("i:" + arr[i]);
                    System.out.println("j:" + arr[j]);
                    return;
                }
            }
        }
        System.out.println("没有相加等于target的元素！");
    }

    /**
     * 将比较的过程放在数组和哈希中，将数组的元素拿出来，【数值】做key，【索引】为value。
     * 使用哈希表作为数据暂存， 因为哈希表的key唯一，查询时间复杂度为O(1)
     */
    public static void HashSearch() {
        int[] arr = RandomArray.getRandomArray(10);
        System.out.println("生成的数组:" + Arrays.toString(arr));
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(TARGET - arr[i]) == null) {
                map.put(arr[i], i);
            } else {
                System.out.println(arr[i]);
                System.out.println(TARGET - arr[i]);
                System.out.println("当前的map:" + map);
                break;
            }
        }
    }


    public static void main(String[] args) {
        //线性搜索  时间复杂度O(n²),空间复杂度o(1).
        LinearSearch();

        // 哈希优化搜索  时间复杂度为O(n),空间复杂度为O(n)
        HashSearch();

    }
}
