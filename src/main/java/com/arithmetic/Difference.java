package com.arithmetic;

/**
 * author: 19045752
 * create: 2021/6/2
 * description: 差分数组 该数组记录了nums[i]和nums[i-1]的差值，通过构建差分数组可以快速修改数组中连续元素的值
 */
public class Difference {
    private final int[] diff;

    // 构建差分数组
    public Difference(int[] nums) {
        int length = nums.length;
        assert length > 0;
        diff = new int[length];
        diff[0] = nums[0];
        for (int i = 1; i < length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 给闭区间[i,j]增加val
    public void increment(int i, int j, int val) {
        diff[i] += val;
        // 如果j+1小于原数组长度 则表示需要修改原数组i后的全部元素值
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    // 通过差分数组构造原数组
    public int[] result() {
        int length = diff.length;
        int[] result = new int[length];
        result[0] = diff[0];
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
}
