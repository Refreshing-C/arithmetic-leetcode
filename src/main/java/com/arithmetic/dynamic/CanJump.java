package com.arithmetic.dynamic;

/**
 * author: Administrator
 * create: 2021/6/12 0012
 * description: 给定一个非负整数数组 nums，你最初位于数组的 第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *          判断你是否能够到达最后一个下标。
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}
