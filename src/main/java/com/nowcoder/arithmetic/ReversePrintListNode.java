package com.nowcoder.arithmetic;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 倒序打印链表
 */
public class ReversePrintListNode {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

