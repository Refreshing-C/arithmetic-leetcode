package com.arithmetic.binarytree;


import java.util.LinkedList;

/**
 * @author 19045752
 * @create 2020/7/21
 * @description 树的广度遍历
 */
public class BreadthTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        breadthTraversal(root);
    }

    private static void breadthTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.peek();
            System.out.println(current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}
