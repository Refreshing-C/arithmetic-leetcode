package com.arithmetic.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * author: Administrator
 * create: 2021/5/29 0029
 * description: 求一棵二叉树的最小高度
 * method: 该题可以看作是二叉树的广度遍历，从根节点开始将二叉树按层级使用队列进行遍历，没遍历一层步数加1，直到到达第一个叶子节点
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 将二叉树的根节点加入队列中
        queue.offer(root);
        // 根节点深度为1
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 将当前队列中的所有节点象四周扩散
            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();
                // 判断是否到达了终点
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                // 将curr的相邻节点加入队列中
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // 增加步数
            depth++;
        }
        return depth;
    }
}
