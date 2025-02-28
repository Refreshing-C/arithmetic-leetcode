package com.nowcoder;

/**
 * 求1+2+3+...+n的和
 */
public class Test47 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(sum_Solution(n));
    }

    public static int sum_Solution(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum_Solution(n - 1);
    }
}
