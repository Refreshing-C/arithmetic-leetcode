package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/15 0015
 * description: 戳气球，有n个气球，标号0到n-1，每个气球上有个数字，这些数字存在nums数组中
 *                  当戳破一个气球i时，可以获得nums[left] * nums[i] * nums[right]个硬币，
 *                  求戳破所有气球时能获得的最大硬币数量。
 * method: 给气球补上两个虚拟节点后，形成一个[0...n+1]的新数组，那么问题就变成戳破气球0和气球n+1之间的所有气球
 *      使最后只剩下0和n+1，能获得的最大硬币数是多少。那么最后一个被戳破的气球是哪个呢，如果为气球k，那么状态就是
 *      k的范围，定义为i，j，选择就是最后戳破的气球是k。
 *      dp[i][j]的含义为戳破i和j间的气球能获得的最大硬币数。
 *      状态转移方程为dp[i][j] = max(dp[i][j],dp[i][k] +nums[i] * nums[k] * nums[j] + dp[k][j])
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        System.arraycopy(nums, 0, points, 1, n);

        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j <= n + 2; j++) {
                for (int k = i + 1; k < j; j++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]
                    );
                }
            }
        }
        return dp[0][n + 1];
    }
}
