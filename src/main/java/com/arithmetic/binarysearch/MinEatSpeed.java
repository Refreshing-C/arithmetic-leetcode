package com.arithmetic.binarysearch;

/**
 * author: Administrator
 * create: 2021/5/12 0012
 * description: 有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉，每小时以某个速度吃香蕉，要在k小时内吃完问最小速度是多少
 * method：吃香蕉的最小速度为1，最大速度为最大一堆香蕉的个数，需要在连续的元素中找到目标值，可以使用二分查找。
 */
public class MinEatSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = getMax(piles);
        while (min < max) {
            int mid = (min + max) / 2;
            if (canFinish(piles, h, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile / speed) + ((pile % speed) > 0 ? 1 : 0);
        }
        return time <= h;
    }
}
