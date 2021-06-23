package com.arithmetic.binarytree;

/**
 * author: 19045752
 * create: 2021/4/28
 * description:
 */
public class TreeNodeApp {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(4);
        TreeNode a2 = new TreeNode(5);
        TreeNode b3 = new TreeNode(6);
        TreeNode b4 = new TreeNode(7);
        a.left = a1;
        a.right = a2;
        a1.left = b1;
        a1.right = b2;
        a2.left = b3;
        a2.right = b4;

        TreeNode root = null;

//        BinaryTreeConvertToListNode.flatten(a);
        int[] nums = new int[]{4, 1, 6, 9, 0, 2, 5, 3};

        root = ConstructMaximumBinaryTree.constructMaximumBinaryTree(nums);

        preorderTraversal(root);
    }

    /**
     * 前序遍历二叉树
     *
     * @param root 二叉树根节点
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
