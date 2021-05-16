package com.arithmetic.doublepointer;

/**
 * author: Administrator
 * create: 2021/5/16 0016
 * description: 删除链表中的重复元素
 * method: 使用快慢指针 当快指针值不等于慢指针值时，将慢指针的下一个元素改为快指针值，
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
