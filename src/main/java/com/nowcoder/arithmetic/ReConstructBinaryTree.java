package com.nowcoder.arithmetic;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 * 解题思路：二叉树前序遍历的第一个元素是根节点，该节点在中序遍历中会把元素划分为二叉树的左子树和右子树的中序遍历，
 * 根据中序遍历的左子树和右子树元素个数，可以将前序遍历除根外的元素划分为左子树的前序遍历和右子树的前序遍历，
 * 进行递归可以得到整棵树
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }

        return reConstructBTree(pre, 0, pre.length - 1, in, 0, pre.length - 1);
    }

    private TreeNode reConstructBTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode node = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                node.left = reConstructBTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                node.right = reConstructBTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return node;
    }
}

