package 排序算法.e_归并排序_merge_sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zijian Wang
 */
public class MergeSort {

    /**
     * 归
     */
    public static void split(int[] arr, int left, int right) {

        //递归退出条件：直到数组长度为1
        if (left >=right) {
            return;
        }
        //选取分割点
        int mid = (left + right) / 2;
        //将左右子组继续分割
        split(arr, left, mid);
        split(arr, mid + 1, right);

        //合并
        merge(arr, left, mid, right);
    }


    /**
     * 合并：比较左右子数组
     */
    public static void merge(int[] arr, int left, int mid, int right) {

        //中间暂存数组
        int[] temp = new int[right - left + 1];
        //左指针
        int i = left;
        //右指针
        int j = mid + 1;
        //temp数组索引
        int index = 0;

        while (i <= mid && j <= right) {
            //从小到大取，依次放入temp中
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        System.out.println("处理："+left+"~"+right+",temp:"+Arrays.toString(temp));

        //将temp放入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[left+k] = temp[k];
        }
        System.out.println("处理后:"+Arrays.toString(arr)+"\n");
    }


    public static void main(String[] args) {

        int[] arr = new int[]{1, 7, 3, 4, 2, 8, 3, 6, 9, 14};
        //归并排序
        split(arr, 0, arr.length - 1);
        /**
         * 时间复杂度：O（nlogn）
         * 空间复杂度：O（n）
         * 稳定性：稳定排序
         * 自适应性：非自适应
         * 原地性： 非原地性
         */
    }
}
