package com.arithmetic.doublepointer;

/**
 * author 19045752
 * create 2020/7/22
 * description 原地删除有序数组的重复项
 * method 可以使用快慢指针 快指针在前面探索 慢指针在后面修改元素的值 当快指针的值不等于慢指针的值 慢指针前进一步 将值更改为快指针的值
 */
public class RemoveArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        removeArrayDuplicates(arr);
    }

    private static void removeArrayDuplicates(int[] arr) {
        int tmp = arr[0];
        int length = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != tmp) {
                tmp = arr[i];
                arr[length] = tmp;
                length++;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }

    }

    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 原地删除有序数组的重复项 使每个元素最多出现两次
     *
     * @param nums nums = [1,2,2,2,2,3]
     * @return
     */
    public int removeDuplicatesLt2(int[] nums) {
        int n = nums.length;
        int fast = 2;
        int slow = 2;
        if (n <= 2) {
            return n;
        }
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;

    }
}
