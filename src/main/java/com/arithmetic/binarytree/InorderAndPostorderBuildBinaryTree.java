package com.arithmetic.binarytree;

/**
 * author: destiny
 * date: 2021/4/28
 * description: 由中序遍历和后序遍历构建二叉树
 * method: 后序遍历的最后一个元素为根节点，在中序遍历中找到根节点的位置，左边为根节点的左子树，右边为根节点的右子树
 * 计算出左子树的个数可在后序遍历中找到左子树或右子树的根节点，递归调用，以前序遍历的方式生成二叉树
 */
public class InorderAndPostorderBuildBinaryTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 构建二叉树
     *
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postOrder
     * @param postStart
     * @param postEnd
     * @return
     */
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postOrder[postEnd];

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(inorder, inStart, index - 1,
                postOrder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postOrder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
