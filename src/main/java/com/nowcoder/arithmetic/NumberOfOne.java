package com.nowcoder.arithmetic;

import java.util.Scanner;

public class NumberOfOne {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = NumberOf1(num);
        System.out.println(result);
    }

    public static int NumberOf1(int n) {

        int result = 0;
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for (char c : ch) {
            if (c == '1') {
                result++;
            }
        }
        return result;
    }

}
