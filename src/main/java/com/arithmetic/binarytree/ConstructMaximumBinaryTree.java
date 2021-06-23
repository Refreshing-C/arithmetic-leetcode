package com.arithmetic.binarytree;

/**
 * author: 19045752
 * create: 2021/4/28
 * description: 构建最大二叉树
 * 二叉树的根是数组中的最大元素
 * 左子树是通过数组中最大值左边的部分构造出来的最大二叉树
 * 右子树是通过数组中最大值右边的部分构造出来的最大二叉树
 * method: 先序遍历 找到数组中的最大元素 生成根节点 最大值左边的部分分给根节点的左子树 右边的部分分给根节点的右子树
 */
public class ConstructMaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 找到数组中的最大值及下标
        int index = -1, maxValue = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] >= maxValue) {
                index = i;
                maxValue = nums[i];
            }
        }

        // 生成根节点
        TreeNode root = new TreeNode(maxValue);

        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);

        return root;
    }
}
