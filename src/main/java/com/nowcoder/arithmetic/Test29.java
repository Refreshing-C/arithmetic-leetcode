package com.nowcoder.arithmetic;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 *
 * @author Destiny
 */
public class Test29 {

    public static void main(String[] args) {

        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 5);
        System.out.println(list);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        sort(input, 0, input.length - 1);
        if (k > input.length) {
            return list;
        } else {
            for (int i = 0; i < k; i++) {
                list.add(input[i]);
            }
            return list;
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && arr[high] >= pivot) {
                    high--;
                }
                swap(arr, low, high);
                while (low < high && arr[low] <= pivot) {
                    low++;
                }
                swap(arr, low, high);
            }

            sort(arr, left, low - 1);
            sort(arr, low + 1, right);
        }

    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
