package com.nowcoder;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            return 3 * Fibonacci(n - 3) + 2 * Fibonacci(n - 4);
        }
    }
}
