package com.arithmetic.binarytree;

/**
 * author: destiny
 * date: 2021/4/28
 * description: 由前序遍历和中序遍历构建二叉树
 * method: 前序遍历的第一个元素为根节点，在中序遍历中找到根节点的位置，左边为根节点的左子树，右边为根节点的右子树
 * 计算出左子树的个数可在前序遍历中找到左子树或右子树的根节点，递归调用，以前序遍历的方式生成二叉树
 */
public class PreorderAndInorderBuildBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 构建二叉树
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // 根节点
        int rootVal = preorder[preStart];
        int index = 0;
        // 找到根节点在中序遍历中的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 左子树长度
        int leftSize = index - inStart;

        // 生成根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归生成左子树和右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index -1);
        root.right =build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }
}
