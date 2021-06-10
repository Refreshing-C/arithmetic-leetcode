package com.arithmetic.bfs;

import java.util.*;

/**
 * author: Administrator
 * create: 2021/5/30
 * description: 一个四位数字的密码锁，经过最小次数的旋转变成target数字，旋转过程中不能出现列表 deadends 中的任何一组死亡数字
 * method: 使用广度优先遍历算法，以0000 作为起点 四位数字每位上拨或者下拨一位，形成与起点起点相邻的图节点，依次类推，形成一幅完整的图
 * 通过图的遍历找到最短路径即最小次数，同时需要记录已经走过的图节点，避免走回头路，当遇到deads时就放弃当前路线。
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        // 记录死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            // 判断是否是死亡密码，是则跳过当前路线
            if (deads.contains(curr)) {
                continue;
            }
            // 判断是否到达了终点
            if (curr.equals(target)) {
                return step;
            }

            // 对当前节点进行扩散，4位数字每位上拨一次下拨一次，要跳过已经访问过的节点
            for (int i = 0; i < 4; i++) {
                String up = plusOne(curr, i);
                if (!visited.contains(up)) {
                    queue.add(up);
                    visited.add(up);
                }

                String down = minusOne(curr, i);
                if (!visited.contains(down)) {
                    queue.add(down);
                    visited.add(down);
                }
            }
            // 扩散一次后增加一次步数
            step++;
        }
        // 未找到则返回-1
        return -1;

    }

    /**
     * 将s[j]向上拨动一次
     *
     * @param s
     * @param j
     * @return
     */
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * 将s[j]向下拨动一次
     *
     * @param s
     * @param j
     * @return
     */
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
