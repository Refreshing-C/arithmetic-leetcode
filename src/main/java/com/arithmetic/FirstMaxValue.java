package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/7/16
 * @description
 */
public class FirstMaxValue {
    public static void main(String[] args) {

        int target = 9;
        int[] arr = new int[]{-1, 1, 3, 4, 8, 10, 13, 18};
        getFirstMaxValue(arr, target);
    }

    private static void getFirstMaxValue(int[] arr, int target) {
        int middle = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > target && (middle == 0 || arr[middle - 1] < target)) {
                System.out.println("第一个比【" + target + "】大的数字是 " + arr[middle]);
                break;
            } else if (arr[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
    }
}
