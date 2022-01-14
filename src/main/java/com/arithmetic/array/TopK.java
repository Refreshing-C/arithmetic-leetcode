package com.arithmetic.array;

/**
 * author: Administrator
 * create: 2022-01-10 18:19
 * description: 从1亿个数据中找出最大的1000个
 * method: 使用小顶堆，创建一个容量为1000的小顶堆，剩下的元素依次和堆顶元素比较，
 *      如果比堆顶元素大就进行替换，然后调整堆
 */
public class TopK {

    public int[] topK(int[] nums, int k) {
        int[] minHeap = new int[k];
        System.arraycopy(nums, 0, minHeap, 0, k);

        for (int i = 0; i < k; i++) {
            int t = i;
            while (t != 0 && minHeap[parent(t)] > minHeap[t]) {
                swap(minHeap, parent(t), t);
            }
        }

        int length = nums.length;

        for (int i = k; i < length; i++) {
            if (nums[i] > minHeap[0]) {
                minHeap[0] = nums[i];
                int t = 0;
                while ((leftChild(t) < length && minHeap[t] > minHeap[leftChild(t)])
                        || (rightChild(t) < length && minHeap[t] > minHeap[rightChild(t)])) {
                    if (rightChild(t) < length && minHeap[rightChild(t)] < minHeap[leftChild(t)]) {
                        swap(minHeap, t, rightChild(t));
                    } else {
                        swap(minHeap, t, leftChild(t));
                    }
                }
            }
        }
        return minHeap;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }
}
