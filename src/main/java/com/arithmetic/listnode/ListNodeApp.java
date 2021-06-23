package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description:
 */
public class ListNodeApp {
    public static void main(String[] args) {
        //测试,建立6个listnode结点对应的val依次为1、2、3、4、5、6
        //最终让3到5的位置的链表发生反转，并重新打印出反转后的元素
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode head = null;

//        ListNode head = reverseBetween(a, 1, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        printListNodeReverse(a);
    }

    /**
     * 倒序打印单链表中的元素值
     *
     * @param head
     */
    public static void printListNodeReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printListNodeReverse(head.next);
        System.out.println(head.val);
    }
}
