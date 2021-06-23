package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description: 判断是否是回文链表
 * method: 链表倒序遍历一遍 与正序遍历进行比较
 */
public class IsPalindromeListNode {

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return recursiveReverse(head);
    }

    public boolean recursiveReverse(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean res = recursiveReverse(right.next);
        // 后序遍历代码
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }
}
