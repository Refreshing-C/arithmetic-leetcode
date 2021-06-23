package com.arithmetic;

/**
 * author: 19045752
 * create: 2021/6/2
 * description: 航班预定统计 航班预定表中第m条数据bookings[m] = [i,j,k]记录了从第i到j的每个航班上预定了k个座位，
 *          请返回每个航班上预定的座位总数。
 * method: 使用差分数组可以快速对航班数组元素进行修改
 */
public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        Difference df = new Difference(result);

        for (int[] booking : bookings) {
            // 航班从1开始，需要减1转为数组索引
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对闭区间[i,j]增加val
            df.increment(i, j, val);
        }
        return df.result();
    }
}
