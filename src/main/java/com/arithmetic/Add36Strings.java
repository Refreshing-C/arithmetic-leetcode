package com.arithmetic;

/**
 * author: Administrator
 * create: 2022-01-10 21:56
 * description: 36进制加法 0-9，a-z共36个字母，要求按照加法规则计算出任意两个36进制正整数的和
 */
public class Add36Strings {
    public static String add36Strings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        int len = Math.max(m, n) + 2;
        char[] res = new char[len];

        while (m >= 0 || n >= 0) {
            int x = m >= 0 ? getInt(num1.charAt(m)) : 0;
            int y = n >= 0 ? getInt(num2.charAt(n)) : 0;

            int ans = x + y + carry;
            res[--len] = getChar(ans % 36);
            carry = ans / 36;
            m--;
            n--;
        }

        StringBuilder str = new StringBuilder();
        for (char ch : res) {
            if (ch == 0) {
                continue;
            }
            str.append(ch);
        }
        return str.toString();
    }

    private static int getInt(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }

    private static char getChar(int n) {
        if(n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    public static void main(String[] args) {
        String num1 = "1b";
        String num2 = "2x";
        System.out.println(add36Strings(num1, num2));
    }
}
