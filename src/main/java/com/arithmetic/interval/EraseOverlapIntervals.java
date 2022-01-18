package com.arithmetic.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * author: Administrator
 * create: 2021/6/12 0012
 * description: 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * method: 贪心算法区间调度 先将所有区间按照结束位置升序排序，选结束最早的一个区间，把所有与该区间相交的区间都删除，
 *      重复该步骤，直到集合中没有元素 选出的这些区间就是最大不相交子集
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 至少有一个区间不相交
        int count = 1;
        // 排序后第一个区间就是结束位置最早的
        int xEnd = intervals[0][1];
        for (int[] interval : intervals) {
            // 区间开始时间大于等于xEnd的，不与x重叠
            if (interval[0] >= xEnd) {
                count++;
                // 更新x
                xEnd = interval[1];
            }
        }
        // 需要移除的区间个数等于总个数减去留下的个数
        return intervals.length - count;
    }
}
