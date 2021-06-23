package com.arithmetic.binarysearchtree;

/**
 * author: 19045752
 * create: 2021/4/29
 * description: 二叉搜索树中第K小的元素
 * method: 二叉搜索树中序遍历是升序顺序
 */
public class BSTKthSmallest {
    int res;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    // 记录当前位置
    int rank = 0;

    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);

        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
