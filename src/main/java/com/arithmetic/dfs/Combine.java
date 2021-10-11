package com.arithmetic.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * author: 19045752
 * create: 2021/5/26
 * description: 输入两个数字n k输出[1, n]中k个数字的所有组合
 * method: 使用回溯算法进行穷举
 */
public class Combine {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        // 如果路径中数字个数达到目标值K，就将该路径加入结果集中
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 选择列表
        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(start);
            // 回溯
            backtrack(n, k, i + 1, track);
            // 撤销选择
            track.removeLast();
        }
    }
}
