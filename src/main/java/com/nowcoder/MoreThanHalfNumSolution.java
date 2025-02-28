package com.nowcoder;

/**
 * 找出数组中出现次数超过一半的数
 *
 * @author Destiny
 */
public class MoreThanHalfNumSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 2, 3, 2, 2, 5, 6, 2, 3, 2, 2, 7};
        System.out.println(moreThanHalfNumSolution(nums));
    }

    public static int moreThanHalfNumSolution(int[] array) {
        int temp = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = array[i];
                count = 1;
            }
        }
        int num = 0;
        for (int value : array) {
            if (value == temp) {
                num++;
            }
        }
        if (num >= array.length / 2)
            return temp;
        else
            return 0;
    }
}
