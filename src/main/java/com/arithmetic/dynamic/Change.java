package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/11 0011
 * description: 凑零钱 给定不同面额的硬币和一个总金额，计算出可以凑成总金额的硬币组合数，假设每种面额硬币无限个。
 * method: dp[i][j]表示使用前i种面额的硬币可以凑出总金额为j的凑法有dp[i][j]种。
 */
public class Change {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
