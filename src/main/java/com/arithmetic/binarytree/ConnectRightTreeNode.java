package com.arithmetic.binarytree;

/**
 * author: 19045752
 * create: 2021/4/28
 * description: 填充每个节点的下一个右侧指针
 * method: 前序遍历将左子树的next指向右子树 但是会出现非同根节点左右子树无法覆盖 可以通过增加方法参数，将相邻的两个节点都连接起来
 */
public class ConnectRightTreeNode {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        connectTwoTreeNode(root.left, root.right);
        return root;
    }

    /**
     * 输入两个节点，将他们连接起来
     *
     * @param node1
     * @param node2
     */
    public void connectTwoTreeNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 前序遍历位置 将两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoTreeNode(node1.left, node1.right);
        connectTwoTreeNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoTreeNode(node1.right, node2.left);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
    }
}
