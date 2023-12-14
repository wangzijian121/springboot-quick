package 选择排序;

import utils.RandomArray;

import java.util.Arrays;

/**
 * 选择排序
 * 思路（找到小的就交换）：
 * 1.遍历整个数组，选择最小的数。（i初始指向0，j指向最小的值）
 * 2.i和j指向的值交换（小的往前放）。
 * 3.i ==j时 排序结束
 *
 * @author zijian Wang
 */
public class SelectionSort {

    final static int SIZE = 10;

    public static int[] selectionSort() {
        int[] array = RandomArray.getRandomArray(SIZE);
        int n = array.length;
        int count = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int k = i;
            //使用k获取i后最小的值
            for (int j = i + 1; j < n; j++) {
                //判断是否是最小的
                count++;
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            //交换i和k的值
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println("执行了：" + count + "次！");
        System.out.println("花费了：" + (endTime - startTime)+ "毫秒！");

        return array;
    }

    public static void main(String[] args) {

        int[] resArray = selectionSort();
//        System.out.println(Arrays.toString(resArray));
        /**
         * 10-> <0ms 45次
         * 100-><0ms 4950次
         * 1000->3ms 499500次
         * 2000->2ms 1999000次
         * 4000->12ms 7998000次
         * 8000->48ms  31996000次
         * 16000->165ms 127992000次
         *
         * 可知：
         * 时间复杂度为：O（n²）
         * 空间复杂度位：O（1）
         * 非稳定排序： 不稳定
         *
         */
    }
}
