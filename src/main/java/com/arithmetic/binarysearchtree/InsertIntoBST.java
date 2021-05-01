package com.arithmetic.binarysearchtree;

/**
 * author: destiny
 * date: 2021/4/30
 * description: 二叉搜索树的插入操作
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
