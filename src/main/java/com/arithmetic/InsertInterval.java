package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Administrator
 * create: 2021-08-23 23:31
 * description: 插入区间 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * method: 找出和新区间不相交的区间，直接放入结果中，将相交的合并为一个大区间，
 * 什么时候应该放入新区间呢？当合并后的区间的右端点比当前区间的左端点小时，将合并后区间放入结果中。
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        boolean place = false;

        List<int[]> ansList = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!place) {
                    ansList.add(new int[]{left, right});
                    place = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                ansList.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }

        if (!place) {
            ansList.add(new int[]{left, right});
        }

        int[][] res = new int[ansList.size()][2];

        for (int i = 0; i < ansList.size(); i++) {
            res[i] = ansList.get(i);
        }
        return res;
    }
}
