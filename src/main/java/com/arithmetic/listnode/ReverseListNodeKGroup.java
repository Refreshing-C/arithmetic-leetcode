package com.arithmetic.listnode;

/**
 * author: 19045752
 * create: 2021/4/27
 * description: 以K个一组 翻转链表 如不够K个，则原样输出
 */
public class ReverseListNodeKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a =head;
        ListNode b = head;
        // 不够K个原样输出
        for (int i = 1; i <= k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
//        (2->1)->(4->3->6->5->null)  -->  2->1->4->3->6->5->null
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 翻转[a, b)间的元素
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode curr = a;
        while (curr != b) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
