package com.arithmetic.listnode;


/**
 * @author 19045752
 * @create 2020/7/22
 * @description 给定一个链表，删除链表的倒数第 n 个节点。
 * @method 快慢指针方法 快指针先走n步，再一起移动到尾节点，慢指针所在节点即待删除节点
 */
public class DeleteListNodeReversed {

    private static ListNode deleteNode(ListNode head, int n) {
        // 创建虚拟头节点 防止原头节点被删除
        ListNode pre = new ListNode(0);
        pre.next = head;

        // 快慢指针
        ListNode fastNode, slowNode;
        fastNode = slowNode = pre;

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

}


