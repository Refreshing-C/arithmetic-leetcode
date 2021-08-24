package com.nowcoder.arithmetic;

/**
 * author: Administrator
 * create: 2021/6/20
 * description:
 */
public class QuickSort {

    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        int pivot = nums[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (nums[i++] < pivot) {
                if (i == high) {
                    break;
                }
            }
            while (nums[--j] > pivot) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * 快速排序
     */

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int low = left;
            int high = right;
            int pivot = arr[low];
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
            quickSort(arr, left, low - 1);
            quickSort(arr, low + 1, right);
        }

    }
}
