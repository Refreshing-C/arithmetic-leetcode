package com.nowcoder;


public class Test13 {

    public static void main(String[] args) {

        int[] arr = {4, 3, 7, 0, 8, 5, 2};

        //记录第一个奇数的位置
        int first = 0;
        //记录排好序后奇数的位置
        int second = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                int temp = arr[i];
                //将第一个奇数前面的数后移一位
                int j = i;
                while (j > 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[0] = temp;
                first = i;
                break;
            }
        }

        for (int j = first + 1; j < arr.length; j++) {
            if (arr[j] % 2 == 1) {
                int temp = arr[j];
                int k = j;
                while (k > second) {
                    arr[k] = arr[k - 1];
                    k--;
                }
                arr[second++] = temp;
            }
        }

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }


}