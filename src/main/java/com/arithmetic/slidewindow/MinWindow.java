package com.arithmetic.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Administrator
 * create: 2021/5/13 0013
 * description: 给你一个字符串 s、一个字符串 t。返回 s 中涵盖 t 所有字符的最小子串
 * method: 字符串中找最小子串 应该考虑滑动窗口，使用双指针形成一个窗口，移动右边界让该窗口涵盖t，之后缩小窗口左边界，
 *      当窗口不再满足涵盖t时，重复移动右边界和缩小左边界，直至右边界到s末尾
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // 计数器 初始化t中字符出现次数和窗口中相应字符的出现次数
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            windowMap.put(c, 0);
        }

        int left = 0;
        int right = 0;
        // 窗口中满足targetMap条件的字符个数 如果valid和targetMap.size大小相同，说明窗口已经完全覆盖了t
        int valid = 0;

        // 最小子串的起始位置
        int start = 0;
        // 最小子串的长度
        int len = Integer.MAX_VALUE;

        // 移动右边界 生成窗口
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            // c为需要的字符
            if (targetMap.containsKey(c)) {
                // 窗口中更新c的出现次数
                windowMap.put(c, windowMap.get(c) + 1);
                // 窗口中c出现次数等于targetMap中c出现次数 说明找到了一个目标字符
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    valid++;
                }
            }

            // 找到完全涵盖t的字符串后考虑缩小窗口左边界
            while (valid == targetMap.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                Character d = s.charAt(left);
                left++;
                // 缩小窗口时考虑减少窗口中目标字符出现次数
                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d).equals(targetMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }

            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        String minStr = minWindow(s, t);
        System.out.println(minStr);

    }
}
