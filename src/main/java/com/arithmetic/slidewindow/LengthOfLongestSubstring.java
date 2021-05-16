package com.arithmetic.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Administrator
 * create: 2021/5/15 0015
 * description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * method: 字符串中找最长子串，使用滑动窗口 当移动窗口右边界时，记录窗口中元素出现次数
 *      当当前元素在窗口中出现次数大于1时，开始缩小窗口左边界，缩小完毕后更新窗口长度
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            while (windowMap.get(c) > 1) {
                Character d = s.charAt(left);
                left++;
                windowMap.put(d, windowMap.get(d) - 1);
            }

            res = Math.max((right - left), res);
        }
        return res;
    }
}
