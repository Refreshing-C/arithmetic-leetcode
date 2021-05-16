package com.arithmetic.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Administrator
 * create: 2021/5/14 0014
 * description: 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列
 * method: 字符串中找子串 使用双指针滑动窗口 当窗口右边进入新元素后，应判断是否是目标元素并更新窗口计数器中目标元素的个数
 * 当窗口大小大于等于子串的大小时开始收缩窗口，判断窗口中元素是否是子串，收缩窗口左边界时应判断移除元素是否是目标元素并更新相应计数器
 */
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            windowMap.put(c, 0);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        // 移动窗口右边界
        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.get(c) + 1);
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    valid++;
                }
            }

            // 当窗口大小大于等于子串大小时开始收缩
            while (right - left >= s1.length()) {
                // 窗口满足子串返回true
                if (valid == targetMap.size()) {
                    return true;
                }
                Character d = s2.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d).equals(targetMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "caa";
        System.out.println(checkInclusion(s1, s2));
    }
}
