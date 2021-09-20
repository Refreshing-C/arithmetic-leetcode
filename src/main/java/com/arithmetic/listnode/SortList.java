package com.arithmetic.listnode;

/**
 * author: Administrator
 * create: 2021-09-19 21:10
 * description: 给你链表的头结点 head，请在O(n log n) 时间复杂度和常数级空间复杂度将其按升序排列并返回排序后的链表。
 * method: O(n log n) 时间复杂度的排序算法有归并排序，堆排序，快排
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        while (temp1 != null) {
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
        }

        while (temp2 != null) {
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }

        return dummy.next;
    }

}
