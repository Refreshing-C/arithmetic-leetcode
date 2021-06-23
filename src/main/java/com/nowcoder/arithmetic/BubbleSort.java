package com.nowcoder.arithmetic;

public class BubbleSort {

    public static void main(String[] args) {

        //此处省略输入数字的方法，直接使用数组保存数字
        int[] arr = new int[]{100, 80, 50, 70, 85, 34, 60};
        bubbleSort(arr);
        //输出结果
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换位置
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }


}
