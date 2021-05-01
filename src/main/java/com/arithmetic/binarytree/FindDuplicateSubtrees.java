package com.arithmetic.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: destiny
 * date: 2021/4/28
 * description: 返回所有重复的子树
 * method: 后序遍历 生成子树 使用HashMap将子树存储起来 判断是否重复
 */
public class FindDuplicateSubtrees {

    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> subTreeMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);
        return res;

    }

    /**
     * 后序遍历寻找重复子树
     *
     * @param root
     * @return
     */
    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + ", " + right + ", " + root.val;

        int count = subTreeMap.getOrDefault(subTree, 0);

        if (count == 1) {
            res.add(root);
        }

        subTreeMap.put(subTree, count + 1);

        return subTree;
    }
}
