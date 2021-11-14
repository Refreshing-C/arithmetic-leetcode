package com.arithmetic.stack;

import java.util.Stack;

/**
 * author: Administrator
 * create: 2021/5/16 0016
 * description: 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 * method: 准备一个栈和数组，数组记录字符串中的字母是否已经存入栈中，如果当前字母比栈中字母小，就把栈中该字母弹出，这样可以实现字典序
 *      但是如果一个较大的字母在字符串中靠前位置只出现了一次，却被弹出了栈，就会导致错误，可以先使用一个数组记录字符串中字母出现次数，判断大小时进行校验。
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> result = new Stack<>();
        // 输入字符均为 ASCII 字符，所以大小 256 够用了
        int[] count = new int[256];
        // 统计字符串中字母出现次数
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            // 每遍历一个字母 就将该字母的次数减1
            count[c]--;
            // 如果该字母在栈中 就跳过
            if (inStack[c]) {
                continue;
            }
            // 比较栈中字母和当前字母大小 如果大于当前字母 就弹出栈中字母
            while (!result.empty() && result.peek() > c) {
                // 如果栈中字母只出现一次，则应停止弹栈
                if (count[result.peek()] == 0) {
                    break;
                }
                inStack[result.pop()] = false;
            }
            result.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!result.empty()) {
            sb.append(result.pop());
        }
        return sb.reverse().toString();
    }
}
