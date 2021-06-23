package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description: 反转链表前N个元素
 */
public class ReverseListNodeN {

    private ListNode reverseN(ListNode head, int n) {
        int index = 1;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (index == n) {
                prev = curr.next;
                break;
            }
            curr = curr.next;
            index++;
        }

        index = 1;
        curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if (index == n) {
                break;
            }
            index++;
        }
        return prev;
    }

    ListNode successor = null;

    private ListNode reverseN2(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN2(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
