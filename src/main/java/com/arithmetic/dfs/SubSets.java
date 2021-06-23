package com.arithmetic.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * author: 19045752
 * create: 2021/5/21
 * description: 输入一个不包含重复数字的数组，输出这些数字的所有子集
 * method: 使用数学归纳法可以发现[a,b]的子集是a的子集和a的子集中每个都添加b的和，那么就可以使用递归来完成求子集
 */
public class SubSets {

    static List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subSets(int[] nums) {

        return recursive(nums, nums.length);
    }

    private List<List<Integer>> recursive(int[] nums, int length) {
        // 当集合为空时 到达递归终止条件 返回空集合
        if (length == 0) {
            List<List<Integer>> tmpList = new LinkedList<>();
            tmpList.add(new LinkedList<>());
            return tmpList;
        }

        // 取出数组中最后一个元素
        int last = nums[length - 1];

        // 递归计算除数组最后一个元素外的子集
        res = recursive(nums, length - 1);

        // 向子集中加入最后一个元素生成新子集 加入结果中
        int size = res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> tmpList = new LinkedList<>(res.get(i));
            tmpList.add(last);
            res.add(tmpList);
        }
        return res;
    }

    /**
     * 回溯解法
     * @param nums
     * @return
     */
    public static List<List<Integer>> subSets2(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private static void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        // 将路径加入结果集
        res.add(new LinkedList<>(track));
        // 选择列表
        for (int i = start; i < nums.length; i++){
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subSets2(nums));
    }
}
