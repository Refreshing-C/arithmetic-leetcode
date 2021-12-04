package com.arithmetic;

import java.util.LinkedList;

/**
 * author: Administrator
 * create: 2021-12-04 17:33
 * description: 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次
 * method: 使用递归计算，遇 [ 进入递归，遇 ] 退出递归，返回结果
 */
public class DecodeString2 {

    public String decodeString(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        return helper(list);
    }

    private String helper(LinkedList<Character> list) {
        int digits = 0;
        StringBuilder res = new StringBuilder();

        while (list.size() > 0) {
            char c = list.pop();
            if (Character.isDigit(c)) {
                digits = digits * 10 + c - '0';
            }
            if ('[' == c) {
                String letter = helper(list);

                StringBuilder subLetter = new StringBuilder();
                while (digits-- > 0) {
                    subLetter.append(letter);
                }
                res.append(subLetter.toString());
                // 重置digits
                digits = 0;
            }
            if (Character.isLetter(c)) {
                res.append(c);
            }

            if (']' == c) {
                break;
            }
        }
        return res.toString();
    }
}
