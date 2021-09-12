package com.arithmetic.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: Administrator
 * create: 2021/5/22 0022
 * description: 给你一个整数数组 nums，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。
 */
public class SubSets {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subSets(int[] nums) {

//        return recursive(nums, nums.length - 1);
        LinkedList<Integer> track = new LinkedList<>();
        return backtrack(nums, 0, track);
    }

    private static List<List<Integer>> recursive(int[] nums, int length) {
        if (length == -1) {
            List<List<Integer>> tmpList = new ArrayList<>();
            tmpList.add(new ArrayList<>());
            return tmpList;
        }
        int last = nums[length];

        res = recursive(nums, length - 1);

        int size = res.size();

        for (int i = 0; i < size; i++) {
            List<Integer> tmp = new ArrayList<>(res.get(i));
            tmp.add(last);
            res.add(tmp);
        }
        return res;

    }

    private static List<List<Integer>> backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(i);
            backtrack(nums, start + 1, track);
            track.removeLast();
        }
        return res;
    }
}

