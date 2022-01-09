package com.arithmetic.array;

/**
 * author: Administrator
 * create: 2022-01-09 22:12
 * description: 归并排序
 */
public class MergeSort {
    public int[] mergeSort(int[] nums) {
        int n = nums.length;

        sort(nums, 0, n - 1);
        return nums;
    }
    private void sort(int[] nums, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, nums, left, temp.length);
    }
}
