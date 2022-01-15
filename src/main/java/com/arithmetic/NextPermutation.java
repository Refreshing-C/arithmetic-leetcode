package com.arithmetic;

/**
 * author: Administrator
 * create: 2022-01-15 22:24
 * description: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前寻找第一个 下一个元素比自身大的 元素
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        // 从后往前找第一个比该元素小的元素
        if (i >= 0) {
            int j = nums.length -1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
