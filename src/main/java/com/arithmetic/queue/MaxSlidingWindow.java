package com.arithmetic.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author destiny
 * @create 2021/5/11
 * @description 找到滑动窗口中的最大值
 * method 使用单调队列来存储窗口元素，保持队列中头元素始终为最大值 就要实现在队头和队尾插入和删除元素 因此可以选用双链表
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    // 单调队列
    static class MonotonicQueue {
        LinkedList<Integer> queue = new LinkedList<>();

        // 在队尾插入元素
        public void push(int k) {
            // 从队尾清除队列中比k小的元素
            while (!queue.isEmpty() && queue.getLast() < k) {
                queue.pollLast();
            }
            queue.addLast(k);
        }

        // 队头即窗口最大元素
        public int max() {
            return queue.getFirst();
        }

        // 移除队头元素
        public void pop(int k) {
            if (k == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }
}


