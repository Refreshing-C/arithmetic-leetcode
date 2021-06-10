package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/7 0007
 * description: 最大子数组和，给定一个整数数组，找到一个具有最大和的连续子数组。
 * method: 动态规划 dp[i]表示当前元素在数组中的最大连续和，由dp[i]到dp[i+1]，做的决策是要么dp[i+1]自成一个数组，
 *      要么和dp[i]合成一个数组。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + dp[i]);
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}
