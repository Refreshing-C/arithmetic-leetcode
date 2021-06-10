package com.arithmetic.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * author: Administrator
 * create: 2021/5/18 0018
 * description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列。
 * method: 全排列问题，可以采用回溯算法，使用队列记录路径，在选择路径前将该路径加入路径队列中，做选择时路径中已有的选择就跳过
 * 选择完成后进行回溯，将该路径从队列中移除，当路径长度和输入数组长度相同时，说明已找完一条路径。
 */
public class Permute {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 一条路径遍历结束，将该路径放入结果中
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        // 选择列表
        for (int num : nums) {
            // 做选择
            if (track.contains(num)) {
                continue;
            }
            // 选择路径
            track.add(num);
            // 进入下一层决策
            backtrack(nums, track);
            // 回溯
            track.removeLast();
        }
    }
}
