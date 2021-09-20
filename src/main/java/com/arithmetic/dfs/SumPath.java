package com.arithmetic.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: Administrator
 * create: 2021-09-19 20:24
 * description: 路径总和 给你二叉树的根节点root和一个整数目标和 targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class SumPath {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, targetSum, track);
        return res;
    }

    private void backtrack(TreeNode root, int targetSum, LinkedList<Integer> track) {
        if (root == null) {
            return;
        }

        track.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if(targetSum == 0) {
                res.add(new LinkedList<>(track));
            }
        }

        backtrack(root.left, targetSum, track);
        backtrack(root.right, targetSum, track);

        track.removeLast();
    }
}
