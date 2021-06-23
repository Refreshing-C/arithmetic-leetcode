package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/12 0012
 * description: 给定一个非负整数数组 nums，你最初位于数组的 第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *          假设总能跳到最后一个位置，请计算最少跳几次能够到达最后一个位置。
 */
public class Jump {

    public int jump(int[] nums) {
        // 在当前位置可以选择的跳跃步数
        int end = 0;
        int jump = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}
