package com.nowcoder.arithmetic;

import java.util.Scanner;

public class Test12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] arr = line.toCharArray();
        int[] array = new int[arr.length];
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }


        for (int i = 0; i < 3; i++) {
            res1 += array[i];
            res2 += array[i + 3];
        }

        if (res1 == res2) {
            System.out.println(0);
            return;
        }

        if (res2 - res1 <= 9) {
            System.out.println(1);
        } else if (res2 - res1 <= 18) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }

    }
}