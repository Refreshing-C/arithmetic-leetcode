package com.arithmetic.binarysearchtree;

/**
 * author: destiny
 * date: 2021/4/29
 * description: 判断一棵二叉搜索树是否是二叉搜索树
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 记录左子树的最大值或右子树的最小值，保证min.val < root.val < max.val
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        // min.val < root.val < max.val
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
