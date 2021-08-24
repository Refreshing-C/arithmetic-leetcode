package com.arithmetic;

import java.util.Arrays;

/**
 * @author 19045752
 * @create 2020/7/22
 * @description
 */
public class RemoveArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        removeArrayDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void removeArrayDuplicates(int[] arr) {
        int fast = 0;
        int slow = 0;
        while (fast < arr.length) {
            if (arr[fast] != arr[slow]) {
                arr[++slow] = arr[fast];
            }
            fast++;
        }

        for(int i = slow + 1; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
