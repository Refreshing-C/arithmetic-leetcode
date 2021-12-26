package com.arithmetic.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * author: Administrator
 * create: 2021-08-24 21:51
 * description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *          请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * method: 将所有的区间按照start排序，取第一个区间的start和end作为标杆[left,right]，依次遍历剩下的区间，
 *      对left和right进行更新，如果遇到不在left和right范围内的区间，将left和right加入结果，新区间作为left和right继续遍历。
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        if (intervals.length == 0) {
            return new int[0][];
        }
        List<int[]> ansList = new ArrayList<>();

        int[] temp = intervals[0];
        int left = temp[0];
        int right = temp[1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= right) {
                right = Math.max(interval[1], right);
            } else {
                ansList.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        ansList.add(new int[]{left, right});

        int[][] res = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            res[i] = ansList.get(i);
        }

        return res;
    }


}
