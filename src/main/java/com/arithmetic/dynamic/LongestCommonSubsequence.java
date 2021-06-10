package com.arithmetic.dynamic;

import java.util.Arrays;

/**
 * author: Administrator
 * create: 2021/6/9 0009
 * description: 最长公共子序列 输入两个字符串s1和s2，请找出他们俩的最长公共子序列
 * method: 使用两个指针分别在两个字符串上移动，当两个指针所指的元素相同时，表示找到了一个公共子序列，
 *      当两个元素不相等时，可能有三种情况，一是s1的当前元素不在公共子序列中，则右移s1指针，
 *      二是s2的当前元素不在公共子序列中，则右移s2指针，三是s1、s2的当前元素都不在公共子序列中，则均右移一位。
 *      此时就求三种情况的最大值，因为情况三均右移一位，必定不是最长的，该情况可不考虑。
 */
public class LongestCommonSubsequence {
    int[][] memo;
    public int longestCommonSubsequence(String s1, String s2) {
        // 将备忘录全部填充为-1
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int[] inner : memo) {
            Arrays.fill(inner, -1);
        }

        return dp(s1, 0, s2, 0);
    }

    public int dp(String s1, int i, String s2, int j) {
        // s1、s2有一个找到结尾即终止，公共子序列长度为0
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // 先查备忘录
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1  + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }

    public int longestCommonSubsequence2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 定义：s1(0, i - 1)和s2(0, j - 1)的最长公共子序列为dp[i][j]
        // 目标：dp[m][n]

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
