package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Fibonacci {

    public static void main(String[] args) {

        long num = getNum2(15);
        System.out.println(num);
    }

    private static long getNum(int n) {
        // f(n+2) = f(n+1) + f(n)
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }

        return getNum(n - 1) + getNum(n - 2);
    }

    public static long getNum2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int res = prev + curr;
            prev = curr;
            curr = res;
        }
        return curr;
    }
}
