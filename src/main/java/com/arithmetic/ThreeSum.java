package com.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: Administrator
 * create: 2021/6/21 0021
 * description: 给定一个数组，从数组中找出和为target的三个元素
 * method: 可以通过寻找target和第一个值的差的方式，套用TwoSums的计算方式
 */
public class ThreeSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSums(int[] nums, int target) {
        Arrays.sort(nums);


        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<List<Integer>> list = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> inner : list) {
                inner.add(nums[i]);
                list.add(inner);
            }
            // 跳过所有重复元素
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int low = start;
        int high = nums.length - 1;
        while (low < high) {
            int left = nums[low];
            int right = nums[high];
            int sum = left + right;
            if (sum < target) {
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }
}
