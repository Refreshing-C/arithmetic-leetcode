package com.arithmetic.dynamic;

/**
 * author: 19045752
 * create: 2021/6/11
 * description: 给定不同面额的硬币和一个总金额，计算初可以凑出总金额的硬币组合数，假设每一种面额硬币有无限个
 * method: dp[i][j]表示使用前i种面额的硬币凑够j的总金额的方式
 */
public class Change {
    public int change(int[] nums, int amount) {
        int n = nums.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j-nums[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
