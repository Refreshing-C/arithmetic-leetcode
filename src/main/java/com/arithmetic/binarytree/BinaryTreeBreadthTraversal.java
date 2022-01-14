package com.arithmetic.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> levelToNode = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return res;
        }

        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i = 1; i <= size; i++) {
                TreeNode current = queue.pop();
                levelToNode.put(level, current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }

        }

        for(int i = 1; i <= level; i++) {
            res.add(levelToNode.get(i));
        }

        return res;
    }
}
