package com.arithmetic.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Administrator
 * create: 2021-10-11 23:15
 * description: 给定两个区间集合，找到两个集合的区间交集
 */
public class IntervalInterSection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;

        int i = 0;
        int j = 0;

        List<int[]> ansList = new ArrayList<>();

        while (i < m && j < n) {
            int a1 = firstList[i][0];
            int a2 = firstList[i][1];

            int b1 = secondList[j][0];
            int b2 = secondList[j][1];

            if (b2 >= a1 && b1 <= a2) {
                ansList.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }

            if (a2 <= b2) {
                i++;
            } else {
                j++;
            }
        }

        int len = ansList.size();
        int[][] res = new int[len][2];

        for (int k = 0; k < len; k++) {
            res[i] = ansList.get(i);
        }

        return res;
    }
}
