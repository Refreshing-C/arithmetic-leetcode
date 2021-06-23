package com.arithmetic;

/**
 * author: 19045752
 * create: 2021/6/3
 * description: 给一个长度为N的数组，数组中装着[1,N]这几个元素，且无序，但元素发生错误，某元素丢失，另一个元素重复，
 *          请找出丢失的元素和重复的元素
 * method: 数组中的元素和索引是成对出现的 判断数组中缺失或者重复的数据，可以采用排序 异或 映射的方式，
 *      如元素缺失，则和索引异或时，未缺失元素和处理后的索引异或后为0，重复元素映射索引时会出现索引已被映射，这样就可以很快捷地找到。
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }
}
