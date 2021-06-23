package com.arithmetic.dynamic;

/**
 * @author 19045752
 * @create 2020/7/16
 * @description
 */
public class MaxPublicSubstring {
    public static void main(String[] args) {
        String a = "12345243991933";
        String b = "134569";

//        getMaxPublicSubstring(a, b);
        getMaxPublicSubString2(a, b);
    }

    private static void getMaxPublicSubstring(String a, String b) {

        String maxSubstr = "";
        int maxLen = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    for (int k = i, m = j; k < a.length() && m < b.length(); k++, m++) {
                        if (a.charAt(k) != b.charAt(m)) {
                            break;
                        }
                        if (maxLen < k - i + 1) {
                            maxLen = k - i + 1;
                            maxSubstr = a.substring(i, k + 1);
                        }
                    }
                }
            }
        }

        System.out.println(a + " and " + b + " maxSubString is " + maxSubstr);
    }

    // 使用动态规划解决问题

    /**
     * 解题思路：
     * 动态规划的6个步骤：
     * 分阶段 对于每一个起点 它后面的每一个字符都是一个阶段
     * 找状态 当前寻找到的相匹配的字符
     * 做决策 当前找到的字符是否相等
     * 状态转移方程 如果当前公共字串为123，且a字符串和b字符串在123后面的字符串相同，则把该字符串加入公共子串
     * 定目标 寻找最大的公共字串
     * 寻找终止条件 决策到了不相等的结果
     *
     * 使用二维数组来表示a字符串和b字符串，a和b相等的位置均可以作为起点，从起点开始寻找最远距离
     */

    private static void getMaxPublicSubString2(String a, String b) {

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    index = i;
                }
            }
        }

        String maxSubstr = a.substring(index - maxLen, index);
        System.out.println(a + " and " + b + " maxSubString is " + maxSubstr);
    }
}
