package com.arithmetic;


import java.util.LinkedList;

/**
 * @author 19045752
 * @create 2020/7/21
 * @description 树的广度遍历
 */
public class BreadthTraversal {
    public static void main(String[] args) {
        Node root = new Node();
        breadthTraversal(root);
    }

    private static void breadthTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        Node current = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.peek();
            System.out.println(current.data);
            if (current.leftChild != null) {
                queue.offer(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.offer(current.rightChild);
            }
        }
    }

    static class Node {
        String data;
        Node leftChild;
        Node rightChild;
    }
}
