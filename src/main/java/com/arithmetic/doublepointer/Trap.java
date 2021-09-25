package com.arithmetic.doublepointer;

/**
 * author: Administrator
 * create: 2021/6/14 0014
 * description: 接雨水 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子下雨之后能接多少雨水
 * method: 使用双指针，限制当前柱子能装多少水取决于它左右两边哪根柱子短
 */
public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
