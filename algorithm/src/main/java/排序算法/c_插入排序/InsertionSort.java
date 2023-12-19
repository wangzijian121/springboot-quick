package 排序算法.c_插入排序;

import utils.RandomArray;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author zijian Wang
 */
public class InsertionSort {

    /**
     * 类似打扑克抓牌
     * 指针移动->插入->移动->插入
     * 只到 移动到 左<= num < 右 时完成
     */
    public static void insertionSort() {
        int[] arr = RandomArray.getRandomArray(10);
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            //移动-向前交换
            int base = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > base) {
                //向右移动
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = base;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        //插入排序
        insertionSort();
        /**
         * 时间复杂度：O(n²)
         * 空间复杂度:O(1)
         * 稳定性：稳定
         * 自适应性：自适应(最佳时为O(n))
         * 原地性：原地排序
         * 操作单元：1. 中间base ，
         */
    }
}
