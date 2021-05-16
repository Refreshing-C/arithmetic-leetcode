package com.arithmetic.binarysearch;

/**
 * author: Administrator
 * create: 2021/5/13 0013
 * description: 第 i 个包裹的重量为 weights[i]，按照顺序使用船在D天内运完，求船的最小载重
 * method：船的最小载重为包裹的最大重量，最大载重为所有包裹的重量和，需要在连续的元素中找到目标值，可以使用左边界二分查找。
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int min = getMax(weights);
        int max = getSum(weights);
        while (min < max) {
            int mid = (min + max) / 2;
            if (canFinish(weights, D, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canFinish(int[] weights, int D, int mid) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int max = mid;
            while ((max -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}
