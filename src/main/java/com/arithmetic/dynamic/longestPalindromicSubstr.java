package com.arithmetic.dynamic;

import java.util.Arrays;

/**
 * author: 19045752
 * create: 2020/9/18
 * description: 最长的回文子串
 * method: 解题思路：按照回文串的定义，如果$s$是回文串，那么去除该串两端的字符，该串仍然是回文串，可以用动态规划来完成。
 *      分阶段：每一个起点后面的字符串都可以作为一个阶段
 *      找状态：首尾相同的字符串
 *      做决策：首尾字符是否相同
 *      状态转移方程：首尾字符相同 剩余子串为回文串
 *      dp[i][j]: 字符串[i,j]是否是回文串
 *      定目标：找到的子串中长度最长的一个
 *      终止条件：决策到了首尾不相同的字符
 */
public class longestPalindromicSubstr {

    public static void main(String[] args) {

        String str = "cbbdbb";

        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {


        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        String maxStr = "";

        for (int i = 0; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int k = i + j;
                if (i == 0) {
                    dp[j][k] = true;
                } else {
                    if (i == 1) {
                        dp[j][k] = (s.charAt(j) == s.charAt(k));
                    } else {
                        dp[j][k] = (s.charAt(j) == s.charAt(k)) && dp[j + 1][k - 1];
                    }
                }

                if (dp[j][k] && i + 1 > maxStr.length()) {
                    maxStr = s.substring(j, j + i + 1);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return maxStr;
    }

}
