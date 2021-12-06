package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description: 反转链表前N个元素
 */
public class ReverseListNodeN {

    // 1 2 3 4 5
    public static ListNode reverseN(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode successor = null;
        ListNode curr = head;
        while (curr != null) {
            if (n-- > 0) {
                ListNode next = curr.next;
                successor = next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } else {
                break;
            }
        }
        head.next = successor;
        return prev;
    }

    static ListNode successor = null;

    public static ListNode reverseN2(ListNode head, int n) {
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
