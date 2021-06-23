package com.arithmetic.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * author: Administrator
 * create: 2021/6/12 0012
 * description: 用最少数量的箭引爆气球 二维空间里随机放了很多气球，垂直向上射出一箭，可以把所有在箭经过范围内气球射爆，
 *          问最少要多少支箭可以射爆所有气球。
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int xEnd = points[0][1];
        for (int[] point : points) {
            if (point[0] > xEnd) {
                count++;
                xEnd = point[1];
            }
        }
        return count;
    }
}
