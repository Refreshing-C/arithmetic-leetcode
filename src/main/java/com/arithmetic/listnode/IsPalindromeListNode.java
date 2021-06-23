package com.arithmetic.listnode;

/**
 * author: destiny
 * date: 2021/4/27
 * description: 判断是否是回文链表
 * method: 反转链表的后一半和前一半对比 可以使用快慢指针找到链表的中心
 */
public class IsPalindromeListNode {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 如果fast不指向null，说明链表长度为奇数，slow需要后移一位
        if (fast != null) {
            slow = slow.next;
        }

        // 反转slow及以后的元素
        ListNode right = reverse(slow);

        ListNode left = head;
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;


    }


    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
