package com.arithmetic.listnode;

import java.util.Stack;

/**
 * author: Administrator
 * create: 2021-08-31 22:13
 * description: 重排链表
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = getMiddle(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(head, l2);

    }

    private static ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private static void merge(ListNode l1, ListNode l2) {
        ListNode temp1;
        ListNode temp2;
        while (l1 != null && l2 != null) {
            temp1 = l1.next;
            temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;

            l2.next = l1;
            l2 = temp2;
        }
    }
}
