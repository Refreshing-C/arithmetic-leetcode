package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description
 */
public class RotateArray {

    /**
     * 旋转有序数组，判断某个数是否在里面
     */

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 6, 7, 9, 2, 3};
        int exists = isExists(arr, 8, 0, arr.length - 1);
        System.out.println(exists);
    }

    private static int isExists(int[] arr, int target, int begin, int end) {
        if (begin == end) {
            if (target == arr[begin]) {
                return begin;
            } else {
                return -1;
            }
        }

        int mid = (begin + end) / 2;

        if (target == arr[mid]) {
            return mid;
        }

        if (arr[begin] <= arr[mid - 1]) {
            if (arr[begin] <= target && target <= arr[mid - 1]) {
                return isExists(arr, target, begin, mid - 1);
            } else {
                return isExists(arr, target, mid + 1, end);
            }
        } else {
            if (arr[mid + 1] <= target && target <= arr[end]) {
                return isExists(arr, target, mid + 1, end);
            } else {
                return isExists(arr, target, begin, mid - 1);
            }
        }
    }
}
