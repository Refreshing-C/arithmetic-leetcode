package com.nowcoder.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列需要可以从两端删除元素，因此使用双端队列。
 * 原则：
 * 对新来的元素k，将其与双端队列中的元素相比较
 * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了）,
 * 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 * 队列的第一个元素是滑动窗口中的最大值
 */
public class Test64 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (num == null || num.length == 0) {
            return res;
        }
        if (num.length < size || size < 1) {
            return res;
        }

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < size - 1; i++) {
            //如果num[i] > 队尾元素, 则移出队列
            while (!deque.isEmpty() && num[i] > num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            //如果num[i] > 队尾元素, 则移出队列
            while (!deque.isEmpty() && num[i] > num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //队列中比num[i]大的元素,则判断是否还在窗口中,如果不在则移出
            if (i - deque.getFirst() + 1 > size) {
                deque.removeFirst();
            }
            //队头是滑动窗口的最大值的下标
            res.add(num[deque.getFirst()]);
        }
        return res;
    }
}
