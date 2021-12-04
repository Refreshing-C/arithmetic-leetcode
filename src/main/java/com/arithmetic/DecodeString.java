package com.arithmetic;

import java.util.Collections;
import java.util.LinkedList;

/**
 * author: Administrator
 * create: 2021-12-04 10:53
 * description: 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次
 * method: 用一个栈存储重复次数和字符串，遇到数字时解析出数字或连续多个数位并入栈，遇到[或者字母直接入栈，
 * 当遇到]时开始出栈，一直到左括号出栈，将出栈的字符拼接反转，继续取栈顶数字，组成解析后的字符串重新入栈。
 */
public class DecodeString {

    int index = 0;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();

        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(c) || c == '[') {
                stack.addLast(String.valueOf(s.charAt(index++)));
            } else {
                ++index;
                LinkedList<String> letterList = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    letterList.addLast(stack.removeLast());
                }
                Collections.reverse(letterList);
                // 左括号出栈
                stack.removeLast();
                // 重复次数出栈
                int repTime = Integer.parseInt(stack.removeLast());
                String letter = getString(letterList);
                StringBuilder sb = new StringBuilder();
                while (repTime-- > 0) {
                    sb.append(letter);
                }
                stack.addLast(sb.toString());
            }
        }
        return getString(stack);
    }

    private String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }

    private String getString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String v : list) {
            sb.append(v);
        }
        return sb.toString();
    }
}
