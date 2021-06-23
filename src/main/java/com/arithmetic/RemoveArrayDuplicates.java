package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/7/22
 * @description
 */
public class RemoveArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        removeArrayDuplicates(arr);
    }

    private static void removeArrayDuplicates(int[] arr) {
        int tmp = arr[0];
        int length = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != tmp) {
                tmp = arr[i];
                arr[length] = tmp;
                length++;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }

    }
}
