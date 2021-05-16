package com.arithmetic.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: Administrator
 * create: 2021/5/15 0015
 * description: 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * method: 在字符串中找子串，使用滑动窗口 当窗口大小大于等于子串长度时，判断子串是否符合，记录子串起始位置
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            windowMap.put(c, 0);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        // 移动窗口右边界
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.get(c) + 1);
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    valid++;
                }
            }

            // 当窗口大小大于等于子串长度时，开始缩小窗口左边界
            while (right - left >= p.length()) {
                // 将满足条件的起始下标加入result
                if (valid == targetMap.size()) {
                    result.add(left);
                }
                Character d = s.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d).equals(targetMap.get(d))){
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return result;
    }
}
