package com.arithmetic.stack;

import java.util.Stack;
import java.util.Vector;

/**
 * author: Administrator
 * create: 2021/5/10 0010
 * description: 找到下一个更大的元素 如果没有返回-1
 * method: 模拟站队 使用栈来存储元素，只存储站队时可以看到人
 */
public class NextGreaterNum {
    public int[] nextGreaterNum(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length -1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                // 将看不到的矮个子移除
                stack.pop();
            }
            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
