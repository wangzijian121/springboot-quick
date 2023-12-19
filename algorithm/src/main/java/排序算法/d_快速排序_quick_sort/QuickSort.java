package 排序算法.d_快速排序_quick_sort;

import utils.RandomArray;

import java.util.Arrays;

/**
 * 快速排序 分治思想
 *
 * @author zijian Wang
 */
public class QuickSort {


    /**
     * 获取基准数
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static void  quickSort(int[] arr, int left, int right) {

        int i = left, j = right;
        if(left>=right){
            return ;
        }
        while (i < j) {
            //右到右，找首个最小值
            while (j > i && arr[j] >= arr[left]) {
                j--;
            }
            //左到右，找首个最大值
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            //交换
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            System.out.println("交换："+i+"和"+j);
        }
        //交换left和基准
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);

//        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = RandomArray.getRandomArray(10);
        System.out.println("初始化："+ Arrays.toString(arr));
        quickSort(arr,0, arr.length-1);
        System.out.println("快速排序后："+ Arrays.toString(arr));
        /**
         * 时间复杂度：O(n logn)
         * 空间复杂度：O(n)
         * 稳定性：非稳定
         * 自适应性： 自适应
         * 就地性：原地排序
         *
         */

    }
}
