package com.arithmetic.dynamic;

import java.util.HashMap;

/**
 * author: Administrator
 * create: 2021/6/17 0017
 * description:
 */
public class MaxProfit {

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，若只允许买卖一次，可获得的最大收益是多少
     * 固定卖出价格，找最小的买入价格
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        int currMin = prices[0];
        for (int sell = 1; sell < prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            res = Math.max(res, prices[sell] - currMin);
        }
        return res;
    }

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，可以多次买卖，但必须卖出后才能再次买入，可获得的最大收益是多少
     * 递归计算，每进行一次买入卖出后，数组规模就会减小，再次进行买入卖出
     *
     * @param prices
     * @return
     */
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int maxProfitMulti(int[] prices) {
        int n = prices.length;
        return dp(0, prices);
    }

    private int dp(int start, int[] prices) {
        int n = prices.length;
        if (start >= n) {
            return 0;
        }

        if (memo.getOrDefault(start, -1) != -1) {
            return memo.get(start);
        }
        int res = 0;
        int currMin = prices[start];
        for (int sell = start + 1; sell < n; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            res = Math.max(res, dp(sell + 1, prices) + prices[sell] - currMin);
        }
        memo.put(start, res);
        return res;
    }

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，可以多次买卖，但必须卖出后等待一天才能再次买入，可获得的最大收益是多少
     * 使用贪心算法 能赚一点就赚一点
     * @param prices
     * @return
     */
    public int maxProfitMulti2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    /**
     * 给定一个数组，它的第i个元素是某只股票第i天的价格，可以买卖K次，但必须卖出后才能再次买入，可获得的最大收益是多少
     * @param prices
     * @return
     */
    HashMap<Integer, Integer> memo2 = new HashMap<>();
    public int maxProfitInK(int[] prices, int k) {
        return dp(0, k, prices);
    }

    private int dp(int start, int k, int[] prices) {
        int n = prices.length;
        if (start >= n || k == 0) {
            return 0;
        }

        if (memo2.getOrDefault(start, -1) != -1) {
            return memo2.get(start);
        }

        int res = 0;
        int currMin = prices[start];
        for (int sell = start + 1; sell < n; sell++) {
            currMin = Math.min(currMin, sell);
            res = Math.max(res, dp(start + 1, k - 1, prices) + prices[sell] - currMin);
        }
        memo2.put(start, res);
        return res;
    }
}
