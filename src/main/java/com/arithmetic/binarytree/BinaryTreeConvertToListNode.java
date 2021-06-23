package com.arithmetic.binarytree;

/**
 * author: 19045752
 * create: 2021/4/28
 * description: 将二叉树转换为链表
 * method:  1、将二叉树的左右子树拉平
 * 2、将整个左子树移到右子树
 * 3、将原有右子树补到新右子树末尾
 */
public class BinaryTreeConvertToListNode {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // 后序遍历位置

        // 记录下左右子树 将左子树移到右子树上 左子树置为null
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        // 将原有的右子树补到新右子树末尾
        TreeNode t = root;
        while (t.right != null) {
            t = t.right;
        }
        t.right = right;
    }
}
