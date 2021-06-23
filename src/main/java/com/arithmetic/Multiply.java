package com.arithmetic;

/**
 * author: 19045752
 * create: 2021/6/13
 * description: 字符串乘法运算，给定两个纯数字字符串，将这两个字符串按照数字乘法运算方式计算出结果，最后将结果以字符串形式返回
 * method: 仿照乘法的计算方式，从各位开始取一位被乘数和乘数进行乘法，使用一个数组来保存和更新每次计算的结果。
 *      假如取i,j两位字符，i*j的结果应该放在数组中i+j，i+j+1的位置
 */
public class Multiply {
    public static String multiply(String a, String b) {

        int m = a.length();
        int n = b.length();
        // 结果最多m+n位
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                // 累加到res上
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        // 数组前几位可能为0
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }

        StringBuilder str = new StringBuilder();
        for (; i < res.length; i++) {
            str.append(res[i]);
        }
        return str.toString();
    }

}
