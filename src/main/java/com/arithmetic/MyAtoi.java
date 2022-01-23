package com.arithmetic;

/**
 * author: Administrator
 * create: 2022-01-23 22:42
 * description:
 */
public class MyAtoi {

    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        char[] chArr = s.toCharArray();

        while (index < n && chArr[index] == ' ') {
            index++;
        }

        if(index == n) {
            return 0;
        }

        int sign = 1;
        char firstChar = chArr[index];
        if(firstChar == '+') {
            index++;
        } else if(firstChar == '-') {
            index++;
            sign = -1;
        }

        int ans = 0;
        while (index < n) {
            if(chArr[index] < '0' || chArr[index] > '9') {
                break;
            }
            int num = chArr[index] - '0';
            int curr = ans * 10 + num * sign;
            if(curr / 10 != ans) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = curr;
            index++;
        }
        return ans;
    }
}
