package com.arithmetic.binarytree;


import com.arithmetic.listnode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: 19045752
 * date: 2020/7/21
 * description: 树的广度遍历
 * method: 使用队列将每一层的元素存入，再取出依次打印
 */
public class BinaryTreeBreadthTraversal {

    public List<List<Integer>> breadthTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < queue.size(); i++) {
                TreeNode current = queue.poll();
                list.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
