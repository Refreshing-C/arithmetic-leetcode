package com.nowcoder.arithmetic;

/**
 * 求1+2+3+...+n的和
 */
public class Test47 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(sum_Solution(n));

    }

    public static int sum_Solution(int n) {
        int sum = n;
        boolean f = (n > 0) && ((sum += sum_Solution(n - 1)) > 0);
        return sum;
    }
}
