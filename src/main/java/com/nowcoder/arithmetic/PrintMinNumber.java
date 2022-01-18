package com.nowcoder.arithmetic;

import java.util.ArrayList;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 解题思路：将正整数数组转换为字符串数组，利用字符串的比较方法，确定数字的排列位置
 */
public class PrintMinNumber {

    public String printMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        list.sort((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        StringBuilder minStr = new StringBuilder();
        for (Integer in : list) {
            minStr.append(in);
        }
        return minStr.toString();
    }
}
