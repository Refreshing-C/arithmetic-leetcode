package com.arithmetic.binarysearchtree;

/**
 * author: destiny
 * date: 2021/4/30
 * description: 删除二叉搜索树中的节点 保证二叉搜索树性质不变
 * method: 待删除节点的位置可能有3个 1：叶子节点 无孩子 可以直接删除
 *          2：有一个孩子的节点 需要让孩子节点来替代自己的位置
 *          3：有左右两个孩子的节点 需要用左子树的最大值或右子树的最小值来替代自己
 */
public class BSTDeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getRightMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    /**
     * 寻找右子树最小节点
     * @param root
     * @return
     */
    public TreeNode getRightMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
