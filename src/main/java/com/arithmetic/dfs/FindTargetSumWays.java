package com.arithmetic.dfs;

/**
 * author: 19045752
 * create: 2021/6/5
 * description: 给定一个非负整数数组和一个目标值target，现有+ -两个符号，可以任选一个添加到数组种每个元素前面，
 * 返回可以使最终数组和为目标值的所有符号添加方案。
 * method: 采用回溯算法，选择列表为+ -号，终止条件为当用完所有数组元素后，和为目标值
 */
public class FindTargetSumWays {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, target);
        return result;
    }

    public void backtrack(int[] nums, int i, int rest) {
        // 用完所有数组元素
        if (i == nums.length) {
            // 凑够target
            if (rest == 0) {
                result++;
            }
            return;
        }
        // 给nums[i]添加-号
        rest += nums[i];
        // 回溯
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest -= nums[i];

        // 给nums[i]添加+号
        rest -= nums[i];
        // 回溯
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest += nums[i];
    }
}
