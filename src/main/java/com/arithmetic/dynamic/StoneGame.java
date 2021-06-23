package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/16 0016
 * description: 有一排石头堆，用一个数组piles表示，piles[i]表示第i堆石头有多少个，两人轮流拿石头，一次拿一堆
 *          但是最能拿走最左边或左右边的，假如两人都足够聪明，问最后俩人的得分之差。
 * method: dp[i][j].fir 表示i到j的石头堆中先手能获得的最大分数 dp[i][j].sec表示i到j的石头堆中后手能获得的最大分数
 *      状态为石头堆开始的索引，结束的索引，当前轮到的人，选择为拿最左边的或最右边的
 *      假如我是先手，我拿了最左边的，那到后手拿时我就相当于变成了后手，我只能选[i+1,j].sec，
 *      如果我是后手，先手拿了最左边的，到我我就相当于是先手，我只能选[i+1,j].fir
 */
public class StoneGame {
    public int stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair();
            }
        }

        // 假如只有一个石堆，那先手为石堆石头个数，后手为0
        for (int j = 0; j < n; j++) {
            dp[j][j].fir = piles[j];
            dp[j][j].sec = 0;
        }

        for (int k = 2; k <= n; k++) {
            for (int i = 0; k + i <= n; i++) {
                int j = i + k - 1;
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        return dp[0][n - 1].fir - dp[0][n - 1].sec;
    }
}
