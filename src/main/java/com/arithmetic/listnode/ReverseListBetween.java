package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description: 反转链表第M到N的元素
 */
public class ReverseListBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode successor = null;
        ListNode prev = null;
        ListNode curr = head;
        int index = 1;
        if (m <= 1) {
            return head;
        }

        while (curr != null) {
            if (index + 1 == m) {
                successor = curr;
            }
            if (index == n) {
                prev = curr.next;
                break;
            }
            curr = curr.next;
            index++;
        }

        curr = successor.next;
        index = m;
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
        successor.next = prev;
        return head;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    static ListNode successor = null;

    private static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


}
