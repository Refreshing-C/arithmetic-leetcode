package com.arithmetic.binarysearchtree;

/**
 * author: 19045752
 * create: 2021/4/29
 * description: 把二叉搜索树转换为累加树 每个节点的值更新为大于等于该节点值的和
 * method: 二叉搜索树中序遍历为升序顺序，如果调换中序遍历中左子树和右子树位置 即可成为降序顺序
 */
public class ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);

        sum += root.val;
        root.val = sum;

        convertBST(root.left);

        return root;
    }
}
