package com.arithmetic.dynamic;

import java.util.Arrays;

/**
 * author: Administrator
 * create: 2021/6/10 0010
 * description:给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * method: 该题经过变形可以变成0-1背包问题，用nums数组中的元素填满一个容量为1/2nums数组的和的背包。
 *      dp[i][j]: 用数组前i个元素可以装满容量为j的背包 如果j-nums[i-1]<0则不装第i个元素，否则就是可装可不装
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果和为奇数，不能分割
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (boolean[] inner : dp) {
            Arrays.fill(inner, false);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
