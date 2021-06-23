package com.arithmetic.array;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * author: 19045752
 * create: 2021/6/2
 * description: 数组中第k个最大元素
 * method: 找第K个最大的元素可以使用二叉堆
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            // 堆中元素超过k个时，删除堆顶元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /**
     * 使用快速选择算法查找数组中第K个最大的元素 借鉴了快排思想，每次在放置pivot时，pivot左边的元素都比pivot小，右边都比pivot大，
     * 那么可以比较pivot下标p和k的大小关系，确定k在p的左边或者右边，之后采用二分查找找到第K个最大的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestByQuickSelect(int[] nums, int k) {
        shuffle(nums);
        int low = 0;
        int high = nums.length;
        k = nums.length - k;
        while (low <= high) {
            int p = QuickSort.partition(nums, 0, nums.length - 1);
            if (k < p) {
                high = p - 1;
            } else if (k > p) {
                low = p + 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    public void shuffle(int[] nums) {
        int n = nums.length;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            // 从i到最后一个随机选择一个进行交换
            int index = i + r.nextInt(n - i);
            QuickSort.swap(nums, i, index);
        }
    }
}
