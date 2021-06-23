package com.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * author: 19045752
 * create: 2021/6/2
 * description: 给定一个整数数组和一个整数K,找到该数组中和为K的连续的子数组的个数
 * method: 可以使用前缀和的方式来计算，新开一个数组记录除当前元素外其它前缀数组元素的和，
 * 这样每次计算数组中连续元素的和，只需要操作前缀和数组即可。该题可以采用与twoSums相同的解法去掉一层for，把时间复杂度降到O(N)
 * 每次将前缀和 和 k的差值存入哈希表，这样在遍历前缀和数组时，只需查找差值出现的次数即可。
 */
public class SubArraySum {

    public int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();

        preSum.put(0, 1);

        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int sumMinusK = sum - k;
            if (preSum.containsKey(sumMinusK)) {
                ans += preSum.get(sumMinusK);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
