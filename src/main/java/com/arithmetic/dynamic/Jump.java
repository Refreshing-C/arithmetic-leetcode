package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/12 0012
 * description: 给定一个非负整数数组 nums，你最初位于数组的 第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *          假设总能跳到最后一个位置，请计算最少跳几次能够到达最后一个位置。
 * method: 跳跃时计算在当前位置可以选择的跳跃步数，计算当前位置到最大跳跃步数位置可以到达的最大距离，当下一次跳跃时再次计算，
 *      实际上是每次都选取了当前跳跃范围内最优跳跃位置进行了跳跃。
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
