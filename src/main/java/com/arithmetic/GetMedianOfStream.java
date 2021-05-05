package com.arithmetic;

import java.util.PriorityQueue;

/**
 * @author 19045752
 * @create 2020/7/21
 * @description 使用大顶堆和小顶堆来实现寻找中位数
 */
public class GetMedianOfStream {

    static int count = 0;

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private void output(Integer num) {
        if (count % 2 == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }

        count++;
        System.out.println(maxHeap.peek());
    }

    public static void main(String[] args) {
        GetMedianOfStream stream = new GetMedianOfStream();
        stream.output(0);
        stream.output(1);
        stream.output(2);
        stream.output(9);
        stream.output(3);
        stream.output(5);
    }
}
