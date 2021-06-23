package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/17 0017
 * description: 有一个特殊的键盘包含4个按键，(A) 在屏幕上打印一个A (Ctrl-A) 选中整个屏幕
 *          (Ctrl-C) 复制选中区域到缓冲区 (Ctrl-V) 将缓冲区内容输出到上次输入结束位置，并显示在屏幕上
 *          当按键N次后，屏幕上最多可以显示多少个A呢
 * method: 当N较小时，一直按A可以产生最多数量的A，因为Ctrl-A Ctrl-C会占用两次不产生A，当N较大时，按照
 *      A A ... Ctrl-A Ctrl-C Ctrl-V Ctrl-V ... Ctrl-A Ctrl-C Ctrl-V Ctrl-V ... 这样的次序可以产生最多A
 *      可以用一个一维dp数组 dp[i]表示按键i次后屏幕能产生A的最多数量
 */
public class MaxA {
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 按下一个A
            dp[i] = dp[i - 1] + 1;
            // 按下Ctrl-V的次数
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] + dp[i] * (i - j + 1));
            }
        }
        return dp[n];

    }
}
