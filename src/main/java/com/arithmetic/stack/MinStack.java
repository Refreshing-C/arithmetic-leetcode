package com.arithmetic.stack;

import java.util.Stack;

/**
 * author: Administrator
 * create: 2021-12-02 22:27
 * description: 设计一个支持 push，pop，top操作，并能在常数时间内检索到最小元素的栈。
 * method: 维护一个存储当前进入栈最小元素的栈，同步操作
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        // 维护一个存储当前进入栈最小元素的栈，同步操作
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
