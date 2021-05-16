package com.arithmetic.doublepointer;

/**
 * author: Administrator
 * create: 2021/5/16 0016
 * description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * method: 使用快慢指针，当快指针值不等于val时，慢指针前进一步，将值更改为快指针的值
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
