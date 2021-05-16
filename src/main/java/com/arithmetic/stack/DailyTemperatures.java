package com.arithmetic.stack;

import java.util.Stack;

/**
 * author: Administrator
 * create: 2021/5/11 0011
 * description: 至少要等多少天才能等到一个比今天更暖和的天气 没有返回0
 * method: 使用栈 模拟站队来完成
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.empty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            // 栈中存储元素下标
            stack.push(i);
        }
        return res;
    }
}
