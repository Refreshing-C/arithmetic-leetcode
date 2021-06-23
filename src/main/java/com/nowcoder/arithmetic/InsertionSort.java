package com.nowcoder.arithmetic;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 6, 1, 4, 9, 3, 8};
        insertionSort(arr);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
