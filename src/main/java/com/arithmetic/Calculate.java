package com.arithmetic;


import java.util.LinkedList;
import java.util.Stack;

/**
 * author: Administrator
 * create: 2021/6/14 0014
 * description:实现一个计算器 如计算出3 * (2 - 7 / 4)
 */
public class Calculate {
    public static int calculate(String str) {
        // 将str放入队列中
        LinkedList<Character> list = new LinkedList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return helper(list);
    }

    private static int helper(LinkedList<Character> list) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        while (list.size() > 0) {
            // 去除当前字符方便遇到括号时递归计算
            char c = list.pop();
            // 将字符串转为数字
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 遇到左括号递归计算 可以将()表达式看作一个值
            if (c == '(') {
                num = helper(list);
                // 应该再取一位
                c = list.size() == 0 ? '+' : list.pop();
            }

            // 当前字符是运算符或者到了结尾
            if ((!Character.isDigit(c) && c != ' ') || list.size() == 0) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-1 * num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // 更新运算符 重置下一位数字
                sign = c;
                num = 0;
            }

            // 遇到右括号结束递归 返回结果
            if (')' == c) {
                break;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(calculate("36*(6/(7-4))+10*10"));

    }
}
