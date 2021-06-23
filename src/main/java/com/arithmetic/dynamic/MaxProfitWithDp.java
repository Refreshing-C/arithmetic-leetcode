package com.arithmetic.dynamic;

import java.util.HashMap;

/**
 * author: Administrator
 * create: 2021/6/19 0019
 * description: 使用动态规划解决股票买卖问题
 * method: 状态一共有3个，分别是天数，交易次数，持有状态，可做的选择有买入 卖出 不操作
 *      做的选择和当前的状态是有关系的，用一个三维数组来表示
 *      dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
 *      第i天持有可能是第i-1天持有，第i天不操作，或第i-1天没有持有，第i天买入
 *      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
 *      第i天没有持有可能是第i-1天没有持有，第i天不操作，或第i-1天持有，第i天卖出
 */
public class MaxProfitWithDp {

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，若只允许买卖一次，可获得的最大收益是多少
     * 只允许买卖一次，则K等于1，则两个状态转移方程可以简化为：
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - price[i]) k=0时，显然没有收益
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + price[i])
     *
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
     * dp[i][1] = Math.max(dp[i - 1][1], - prices[i])
     * 发现新状态之和前一个状态有关，那么可以使用变量代替 降低空间复杂度
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, -price);
        }
        return dp_i_0;
    }

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，可以多次买卖，但必须卖出后才能再次买入，可获得的最大收益是多少
     * 当K趋于无穷大时，K和K-1可以看作相等，那么状态转移方程可改为
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - price[i])
     * k就不会对状态产生影响，状态转移方程可化简为
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - price[i])
     *
     * @param prices
     * @return
     */

    public int maxProfitMulti(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price);
        }
        return dp_i_0;
    }


    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，可以多次买卖，但必须卖出后等待一天才能再次买入，可获得的最大收益是多少
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-2][k][0] - price[i])
     * k就不会对状态产生影响，状态转移方程可化简为
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - price[i])
     *
     * @param prices
     * @return
     */
    public int maxProfitMulti2(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_0, dp_pre_0 - price);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，可以买卖K次，但必须卖出后才能再次买入，可获得的最大收益是多少
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - price[i])
     * K最多为天数的一半 如果超过则k就失去了约束作用
     * @param prices
     * @param maxK
     * @return
     */
    HashMap<Integer, Integer> memo2 = new HashMap<>();
    public int maxProfitInK(int[] prices, int maxK) {
        int n = prices.length;
        if (maxK > n / 2) {
            return maxProfitMulti(prices);
        }
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i - 1 == -1) {
                    //
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }

}
