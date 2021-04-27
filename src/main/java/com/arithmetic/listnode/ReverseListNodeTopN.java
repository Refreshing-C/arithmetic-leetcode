package com.arithmetic.listnode;

/**
 * 反转链表前N个节点
 */
public class ReverseListNodeTopN {
    ListNode reverseN(ListNode head, int n) {
        ListNode successor = null;
        ListNode prev = null;
        ListNode curr = head;
        int index = 1;
        while(curr != null) {
            index++;
            if(index >= n) {
                successor = curr.next;
                curr.next = successor;
            } else {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        return prev;
    }
}



