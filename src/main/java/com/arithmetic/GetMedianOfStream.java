package com.arithmetic;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 19045752
 * @create 2020/7/21
 * @description 使用大顶堆和小顶堆来实现寻找中位数
 */
public class GetMedianOfStream {

    int count = 0;

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (count % 2 == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }

        count++;
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        GetMedianOfStream stream = new GetMedianOfStream();
        stream.addNum(0);
        stream.addNum(1);
        stream.addNum(2);
        stream.addNum(9);
        stream.addNum(3);
        stream.addNum(5);
    }
}
