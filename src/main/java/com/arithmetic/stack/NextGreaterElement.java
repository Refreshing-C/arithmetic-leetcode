package com.arithmetic.stack;

import java.util.Stack;

/**
 * author: Administrator
 * create: 2021/5/11 0011
 * description: 假设数组为环形，找到下一个更大的元素
 * method: 可以将数组长度翻倍 使用栈来完成
 */
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 使用循环数组来模拟数组长度翻倍
        for (int i = 2 * n -1; i >=0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
