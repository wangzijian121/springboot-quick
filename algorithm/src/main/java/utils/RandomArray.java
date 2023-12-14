package utils;

import java.util.Arrays;
import java.util.Random;

/**
 * 随机数组生成器
 *
 * @author zijian Wang
 */
public class RandomArray {

    public static int[] getRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(size);
            array[i] = num;
        }
        return array;
    }
}
