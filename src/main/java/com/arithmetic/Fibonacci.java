package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description
 */
public class Fibonacci {

    public static void main(String[] args) {

        long num = getNum(50);
        System.out.println(num);
    }

    private static long getNum(int index) {
        // f(n+2) = f(n+1) + f(n)
        if (index == 1) {
            return 0;
        }
        if (index == 2) {
            return 1;
        }

        return getNum(index - 1) + getNum(index - 2);
    }
}
