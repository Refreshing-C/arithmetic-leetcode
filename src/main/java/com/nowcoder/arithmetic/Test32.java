package com.nowcoder.arithmetic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 解题思路：将正整数数组转换为字符串数组，利用字符串的比较方法，确定数字的排列位置
 */
public class Test32 {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int number : numbers) {
            list.add(number);
        }
        list.sort((n1, n2) -> {
            String s1 = n1 + "" + n2;
            String s2 = n2 + "" + n1;
            return s1.compareTo(s2);
        });
        StringBuilder minStr = new StringBuilder();
        for (Integer in : list) {
            minStr.append(in);
        }
        return minStr.toString();
    }
}
