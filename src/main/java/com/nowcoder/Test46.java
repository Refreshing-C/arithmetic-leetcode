package com.nowcoder;

import java.util.LinkedList;

/**
 * 约瑟夫环问题
 */
public class Test46 {

    public static void main(String[] args) {
        String str = "student. a am I";
        System.out.println(ReverseSentence(str));
    }

    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int start = 0;
        while (list.size() > 1) {
            start = (start + m - 1) % list.size();
            list.remove(start);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        String[] words = str.split(" ");
        StringBuilder sentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i == 0) {
                sentence.append(words[i]);
            } else {
                sentence.append(words[i]).append(" ");
            }
        }

        return sentence.toString();
    }
}


