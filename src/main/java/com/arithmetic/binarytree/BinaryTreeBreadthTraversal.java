package com.arithmetic.binarytree;


import java.util.LinkedList;

/**
 * author: 19045752
 * date: 2020/7/21
 * description: 树的广度遍历
 * method: 使用队列将每一层的元素存入，再取出依次打印
 */
public class BinaryTreeBreadthTraversal {

    public void breadthTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
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
