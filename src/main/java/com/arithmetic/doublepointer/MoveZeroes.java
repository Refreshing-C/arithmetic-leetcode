package com.arithmetic.doublepointer;

/**
 * author: Administrator
 * create: 2021/5/16 0016
 * description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 [0,1,0,3,12]
 * method: 使用快慢指针将0全部删除，再将慢指针之后的元素全部改为0
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
