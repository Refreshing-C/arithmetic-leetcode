package com.arithmetic.dynamic;

/**
 * author: 19045752
 * create: 2021/6/5
 * description: 给定两个字符串s1和s2，计算出将s1转换为s2所使用的最少操作数
 * method: 最短编辑距离，使用两个指针同时开始遍历s1和s2，当前字符相同时，什么都不做，各前进一步；
 *      当前字符不同时，可以对s1进行插入、删除、替换三步中的一步，若插入，则s2前进一步，若删除，则s1前进一步
 *      若替换，则各前进一步。记录步数。当s1或s2遍历结束时，加上未遍历结束的字符串的剩余长度作为步数。
 */
public class MinDistance {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
