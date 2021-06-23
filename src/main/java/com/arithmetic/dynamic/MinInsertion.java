package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/22 0022
 * description: 构造回文串的最小插入次数
 * method: dp[i][j]表示将字符串i到j构造成回文串的最小插入次数
 *      如果s[i] == s[j]时，则插入次数为dp[i+1][j-1]
 *      如果s[i] ≠ s[j]时，要考虑将s[i+1][j]或s[i][j-1]构造成回文串的最小插入次数，然后再插入s[i]或s[j]
 */
public class MinInsertion {

    public int minInsertion(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
