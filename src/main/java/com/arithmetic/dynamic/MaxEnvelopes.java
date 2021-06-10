package com.arithmetic.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * author: Administrator
 * create: 2021/6/6 0006
 * description: 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *          当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里。
 *          请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封
 * method: 将二维数组按照wi升序排列 如果wi相同，则按照hi降序排列，之后将所有的hi作为一个数组，那么该问题就转换为
 *      求hi数组中的最长递增子序列。
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        // 按照宽度升序排列，如果宽度相同，按照高度降序排序
        Arrays.sort(envelopes, (o1, o2) ->
                o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        // 对高度寻找LIS
        int[] top = new int[length];
        // 堆数
        int piles = 0;
        for (int[] envelope : envelopes) {
            int poker = envelope[1];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
