package com.arithmetic.binarysearchtree;

/**
 * author: Administrator
 * create: 2021-09-20 21:28
 * description: 最大路径和 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * method: 路径定义为从树中的任一节点出发，沿着父节点--子节点到达任意节点的序列。
 *      若想获得最大路径和，应当选根节点左子树路径和最大 根节点 根节点右子树路径和最大 的这条路径，
 *      按照定义，路径不能是从根节点到某个子树后再返回根节点再到另一个子树，那么就需要计算以某个节点为根节点
 *      的子树能产生的最大贡献值，
 *
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(maxGain(root.left), 0);
        int rightMax = Math.max(maxGain(root.right), 0);

        int rootSum = root.val + leftMax + rightMax;

        maxSum = Math.max(rootSum, maxSum);

        return root.val + Math.max(leftMax, rightMax);
    }
}
