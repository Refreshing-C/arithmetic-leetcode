package com.arithmetic.dynamic;

import java.util.Arrays;

/**
 * author: 19045752
 * create: 2021/6/11
 * description: 最长回文子序列
 * method: dp[i][j]表示字符串[i,j]的最长回文子序列长度为dp[i][j]
 */
public class LongestPalindromeSubSeq {
    public static int longestPalindromeSubSeq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int[] inner = new int[len];
        Arrays.fill(inner, 1);
        Arrays.fill(dp, inner);

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
