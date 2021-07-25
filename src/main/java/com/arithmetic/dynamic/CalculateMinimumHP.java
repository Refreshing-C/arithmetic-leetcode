package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/7/7
 * description: 输入一个二维数组grid，每个元素是一个随机数，正负不确定，从左上角出发每次向右或者向下移动一步，
 *          在保证每走一步当前的数值都大于0下，问初始值至少是多少可以保证到达最右角时要保证时数值大于0
 * method: 这道题应该倒推，到达右下角的数值为1，可以推出在右下角的前一个元素位置时的最小数值，依次往前推，就能直到
 *      在左上角的最小初始值是多少。
 */
public class CalculateMinimumHP {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : -dungeon[m - 1][n - 1] + 1;

        for (int i = m - 2; i >= 0; i--) {
            int temp = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = temp <= 0 ? 1 : temp;
        }
        for (int j = n - 2; j >= 0; j--) {
            int temp = dp[m - 1][j + 1] - dungeon[m - 1][j];
            dp[m - 1][j] = temp <= 0 ? 1 : temp;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int temp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = temp <= 0 ? 1 : temp;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
