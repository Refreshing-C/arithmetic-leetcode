package com.arithmetic;

/**
 * author: Administrator
 * create: 2022-01-10 20:03
 * description: 将字符串进行编码，如aabbcc编码成a_2_b_2_c_2
 */
public class CodeString {
    public static String codeString(String str) {
        StringBuilder res = new StringBuilder();
        int n = str.length();
        int i = 0;
        while (i < n) {
            char c = str.charAt(i);
            int count = 1;
            while (++i < n && str.charAt(i) == c) {
                count++;
            }
            res.append(c).append("_").append(count).append("_");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbcc";
        System.out.println(codeString(str));
    }
}
