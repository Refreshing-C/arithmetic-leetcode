package com.arithmetic.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * author: destiny
 * date: 2021/5/1
 * description: 二叉树的序列化和反序列化 使用序列化方法生成字符串 反序列化将该字符串变成原二叉树
 */
public class BinaryTreeCodec {
    // Encodes a tree to a single string.
    String SEPARATOR = ",";
    String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder treeSb = new StringBuilder();
        traverse(root, treeSb);
        return treeSb.toString().substring(0, treeSb.length() - 1);
    }

    private void traverse(TreeNode root, StringBuilder treeSb) {
        if (root == null) {
            treeSb.append(NULL).append(SEPARATOR);
            return;
        }
        treeSb.append(root.val).append(SEPARATOR);
        traverse(root.left, treeSb);
        traverse(root.right, treeSb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEPARATOR)));
        return build(nodes);
    }

    /**
     * 前序遍历构建二叉树
     *
     * @param nodes
     * @return
     */
    private TreeNode build(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.poll();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    }

    /**
     * 后序遍历反序列化
     *
     * @param data
     * @return
     */
    public TreeNode postOrderDeserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEPARATOR)));
        return postOrderBuild(nodes);
    }

    /**
     * 后序遍历构建二叉树 从末尾往前取，每次生成root节点后应先生成右子树再生成左子树
     *
     * @param nodes
     * @return
     */
    private TreeNode postOrderBuild(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String last = nodes.pollLast();
        if (NULL.equals(last)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = postOrderBuild(nodes);
        root.left = postOrderBuild(nodes);
        return root;
    }

    /**
     * 二叉树层级遍历反序列化二叉树
     *
     * @param data
     * @return
     */
    public TreeNode breadthDeserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEPARATOR);

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 队列中只放父节点
        LinkedList<TreeNode> parents = new LinkedList<>();
        parents.offer(root);

        for (int i = 1; i < nodes.length; ) {
            TreeNode parent = parents.poll();
            String left = nodes[i++];
            if (!NULL.equals(left)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                parents.offer(parent.left);
            } else {
                parent.left = null;
            }
            String right = nodes[i++];
            if (!NULL.equals(right)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                parents.offer(parent.right);
            } else {
                parent.right = null;
            }
        }

        return root;
    }
}
