package com.arithmetic.dynamic;

import java.util.Arrays;

/**
 * author: Administrator
 * create: 2021/6/9 0009
 * description: 0-1背包 给定一个可装载重量为W的背包和N个物品，第i个物品的重量为wt[i]，价值为val[i]，该背包能装的最大价值是多少
 * method: 分阶段：每装一个物品都是一个新的阶段
 *      找状态：背包的容量和可选的物品
 *      做选择：对每个物品选择装进背包或者不装进背包
 *      状态转移方程：dp[i][w]表示对于前i个物品，当前背包的最大容量为W，可以装的最大价值时dp[i][w],
 *              则dp[i][w] = max(dp[i-1][w], dp[i][w-wt[i]] + val[i])
 *      终止条件：装完i个物品或超过可装载重量W
 *      定目标：最大价值，即dp[n][w]
 */
public class Knapsack {
    public int knapsack(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];
        for (int[] inner : dp) {
            Arrays.fill(inner, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - wt[i] < 0) {
                    dp[i][j] = dp[i - 1][w];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][w - wt[i]] + val[i], dp[i - 1][w]);
                }
            }
        }
        return dp[n][w];
    }
}
