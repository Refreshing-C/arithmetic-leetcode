package com.arithmetic.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: 19045752
 * create: 2021/6/5
 * description: 凑零钱 给你K种面值的硬币，面值分别为C1，C2 ... Ck，每种硬币数量无限，问最少要几枚硬币能凑出给定总金额amount
 * method: 该问题符合动态规划问题，即存在最优子结构，子结构相互独立。
 *      假如总金额为11，现找到总金额为10的最少硬币数量，那么再加一枚硬币即为总金额为11的最少硬币数量。
 *      分阶段：每一枚硬币都是一个阶段
 *      找状态：目标总金额amount
 *      做决策：当前目标金额为n，凑够n所需的最少硬币数量
 *      状态转移方程：从m到n所需的硬币数量为dp[n] = dp[m] + 1 = min(dp[n-coin] + 1)
 *      定目标：找到总金额amount所需的最少硬币数量
 *      终止条件：目标金额为0，返回0，目标金额小于0，返回-1
 */
public class CoinChange {
    public int coinChange(List<Integer> coins, int amount) {
        // 备忘录
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(coins, amount, memo);
    }

    public int dp(List<Integer> coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int res = amount + 1;
        for (Integer coin : coins) {
            int temp = dp(coins, amount - coin, memo);
            if (temp == -1) {
                continue;
            }
            res = Math.min(res, temp + 1);
        }
        memo.put(amount, res == amount + 1 ? -1 : res);
        return memo.get(amount);
    }

    public int coinChange2(List<Integer> coins, int amount) {
        // dp数组
        int[] dp = new int[amount + 1];
        // 全部初始化为amount + 1，因为凑齐amount所需的最大数量为amount
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
