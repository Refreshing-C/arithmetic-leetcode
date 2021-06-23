package com.arithmetic.array;

import java.util.Arrays;

/**
 * author: 19045752
 * create: 2021/6/2
 * description:
 */
public class QuickSort {
    public static int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        // 将nums[left]作为默认分界点
        int pivot = nums[left];
        int low = left;
        int high = right + 1;
        while (true) {
            // 保证nums[left, low]都小于pivot
            while (nums[++low] < pivot) {
                if (low == right) {
                    break;
                }
            }
            // 保证nums[high,right]都大于pivot
            while (nums[--high] > pivot) {
                if (high == left) {
                    break;
                }
            }
            if (low >= high) {
                break;
            }
            // 如果走到这里，则nums[low] > pivot && nums[high] < pivot
            // 就需要交换nums[low]和nums[high] 保证nums[left,low] < pivot < [high,right]
            swap(nums, low, high);
        }
        // 将pivot交换到正确的位置
        swap(nums, left, high);
        return high;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 8, 1, 5, 9, 4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
