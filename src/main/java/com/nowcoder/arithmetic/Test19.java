package com.nowcoder.arithmetic;

public class Test19 {

    public static void main(String[] args) {

        int x = 1, y = 2, z = 3;
        y += z-- / ++x;
        System.out.println(y);

        int a = -2;
        System.out.println(a >> 3);
        System.out.println(a << 3);
    }
}
