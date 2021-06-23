package com.arithmetic;

import java.util.HashSet;

/**
 * @author 19045752
 * @create 2020/9/10
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class MaxSubstr {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        // 滑动窗口
        // 在一次遍历过程中 使用HashSet保存当前遍历过程中的不重复字符 并记录当前最大长度
        // 遍历结束后就得到了最大的不重复长度
        HashSet<Character> singleCharSet = new HashSet<>();

        int len = s.length();
        // 右指针
        int right = -1;
        // 最大长度
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                singleCharSet.remove(s.charAt(i - 1));
            }

            while (right + 1 < len && !singleCharSet.contains(s.charAt(right + 1))) {
                singleCharSet.add(s.charAt(right + 1));
                right++;
            }

            maxLen = Math.max(maxLen, right + 1 - i);
        }

        return maxLen;
    }
}
