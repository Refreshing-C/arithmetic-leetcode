package com.arithmetic;

import java.util.Stack;

/**
 * @author 19045752
 * @create 2020/7/21
 * @description
 */
public class ReverseStr {
    public static void main(String[] args) {
        String str = "This is a good example";
        System.out.println(reverseStr(str));
    }

    private static String reverseStr(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                tmp.append(str.charAt(i));
            } else if (tmp.length() != 0) {
                stack.push(tmp.toString());
                tmp.delete(0, tmp.length());
            } else {
                continue;
            }
        }

        if (tmp.length() != 0) {
            stack.push(tmp.toString());
        }

        String result = "";
        while (!stack.empty()) {
            result += stack.pop() + " ";

        }

        return result.trim();
    }
}
