package com.nowcoder;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。
 * 思路分析：通过序列的长度可以得到中间值，在知道了中间值和序列长度的情况下便可以确定出序列。
 *      因为是连续正数序列，构成了等差数组，可以得到序列长度的范围是0-√2S。
 *      序列长度为奇数时，中间值为序列的平均值，序列长度为偶数时，中间两个数的平均值为序列的平均值
 */
public class Test41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> subList = new ArrayList<Integer>();
                for (int i = 0, j = sum / n - (n - 1) / 2; i < n; i++, j++) {
                    subList.add(j);
                }
                list.add(subList);
            }
        }
        return list;
    }

}
