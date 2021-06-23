package com.arithmetic.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Administrator
 * create: 2021/5/22 0022
 * description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 */
public class SubSets {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subSets(int[] nums) {

        return recursive(nums, nums.length);
    }

    private static List<List<Integer>> recursive(int[] nums, int length) {
        if (length == 0) {
            List<List<Integer>> tmpList = new ArrayList<>();
            tmpList.add(new ArrayList<>());
            return tmpList;
        }
        int last = nums[length];

        res = recursive(nums, length - 1);

        int size = res.size();

        for (int i = 0; i < size; i++) {
            List<Integer> tmp = res.get(i);
            tmp.add(last);
            res.add(i, tmp);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subSets(nums));
    }
}

