package com.arithmetic.dynamic;

import java.util.Arrays;

/**
 * author: Administrator
 * create: 2021/6/6 0006
 * description: 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * method: 使用动态规划 dp数组保存当前字符在数组中最长上升子序列的长度
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * method: 二分查找法 算法来源于扑克牌游戏，将一堆扑克牌像遍历数组那样处理，最后分成若干堆，
     *      只能把点数较小的牌压到点数比它大的牌上，如果当前牌无处可放，则新建一堆，把这张牌放上去。
     *      如果当前牌有多个堆可以放，则放到最左堆上。这样最后这些堆顶的牌有序，堆数为牌中最长递增子序列。
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int poker : nums) {
            // 搜索左侧边界的二分查找
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] < poker) {
                    left = mid + 1;
                } else if (top[mid] > poker) {
                    right = mid;
                } else {
                    right = mid;
                }
            }
            // 没找到合适的牌堆，则新建一堆
            if (left == piles) {
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        return piles;
    }
}
