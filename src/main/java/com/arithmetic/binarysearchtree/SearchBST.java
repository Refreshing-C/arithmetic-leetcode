package com.arithmetic.binarysearchtree;

/**
 * author: destiny
 * date: 2021/4/30
 * description: 在二叉树中搜索元素
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val <= val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
