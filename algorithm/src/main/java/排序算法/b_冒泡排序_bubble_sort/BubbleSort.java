package 排序算法.冒泡排序;

import utils.RandomArray;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zijian Wang
 */
public class BubbleSort {

    /**
     * 对比相邻的两个元素的值，如果右>左，就交换，如果右<左就不变。
     */
    public static void BubbleSort() {
        int[] arr = RandomArray.getRandomArray(10);
        System.out.println("初始：" + Arrays.toString(arr));
        boolean haveChange;
        do {
            haveChange = false;
            for (int i = 0; i < arr.length - 1; i++) {
                //右>左 ,交换
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    haveChange = true;
                }
            }
            System.out.println(Arrays.toString(arr));
        } while (haveChange);
    }

    public static void main(String[] args) {
        //冒泡排序
        BubbleSort();
        /**
         *
         * 时间复杂度是O(n²)
         * 空间复杂度O(1)
         * 自适应性:最佳是 O(n)
         * 原地排序
         * 稳定排序
         */
    }
}
