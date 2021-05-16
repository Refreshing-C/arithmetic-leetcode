package com.arithmetic.doublepointer;


/**
 * @author 19045752
 * @create 2020/7/22
 * @description 给定一个链表，删除链表的倒数第 n 个节点。
 */
public class RemoveSomeone {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        removeSomeone(head, 2);

    }

    private static ListNode removeSomeone(ListNode head, int n) {
        // 创建虚拟头节点 防止原头节点被删除
        ListNode pre = new ListNode(0);
        pre.next = head;

        // 快慢指针
        ListNode fastNode = pre;
        ListNode slowNode = pre;

        // 快指针先走n步
        while (fastNode.next != null && n > 0) {
            fastNode = fastNode.next;
            n--;
        }

        // 快慢指针一起移动到尾节点
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        // 删除倒数第n个节点
        slowNode.next = slowNode.next.next;

        return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

}


