package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description: 单链表结构
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
