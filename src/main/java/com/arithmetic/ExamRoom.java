package com.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * author: Administrator
 * create: 2021/6/14
 * description: 给考生安排考试座位 考场里有N个座位，分别是[0...N-1]，每进来一个同学，要最大化他和最近其他人的距离，
 *          如果有多个这样的座位，安排他到索引最小的那个座位。
 */
public class ExamRoom {
    Map<Integer, int[]> startMap;
    Map<Integer, int[]> endMap;
    TreeSet<int[]> treeSet;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        treeSet = new TreeSet<>((o1, o2) -> {
            int dist1 = distance(o1);
            int dist2 = distance(o2);
            if (dist1 == dist2) {
                return o2[0] - o1[0];
            } else {
                return dist1 - dist2;
            }
        });
    }

    /**
     * 进入一个考生
     */
    private void seat() {
        int seat;
        // 取出最长的线段
        int[] longest = treeSet.last();
        int x = longest[0];
        int y = longest[1];
        if (x == -1) {
            seat = 0;
        } else if (y == n) {
            seat = n - 1;
        } else {
            seat = (y - x) / 2 + x;
        }
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
    }

    private void leave(int seat) {
        int[] left = startMap.get(seat);
        int[] right = endMap.get(seat);

        int[] merged = new int[]{left[0], right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }

    /**
     * 添加一个线段
     * @param interval
     * @return
     */
    private void addInterval(int[] interval) {
        treeSet.add(interval);
        startMap.put(interval[0], interval);
        endMap.put(interval[1], interval);
    }

    /**
     * 移除一个线段
     * @param interval
     */
    private void removeInterval(int[] interval) {
        treeSet.remove(interval);
        startMap.remove(interval[0], interval);
        endMap.remove(interval[1], interval);
    }

    /**
     * 计算线段的长度
     * @param interval
     * @return
     */
    private int distance(int[] interval) {
        int x = interval[0];
        int y = interval[1];
        if (x == -1) {
            return y;
        }
        if (y == n) {
            return n - 1 - x;
        }
        return (y - x) / 2;
    }
}
