package com.arithmetic;

import java.util.*;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description
 */
public class TwoSum {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 2, 4, 2, 0};
        int target = 5;
        List<int[]> res = twoSum(arr, target);
        for (int[] temp : res) {
            System.out.println(temp[0] + " and " + temp[1]);
        }

        //        int[] twoSums = getTwoSums(arr, target);
//        System.out.println(twoSums[0] + " and " + twoSums[1]);


    }

    private static int[] getTwoSums(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

    /**
     * 在数组有序的情况下，使用双指针求解
     * @param nums
     * @param target
     * @return
     */
    public static List<int[]> twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<int[]> res = new ArrayList<>();

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            // 记录起始位置
            int left = nums[low];
            int right = nums[high];
            int sum = left + right;
            if (sum < target) {
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else {
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = right;
                res.add(arr);
                // 跳过重复元素
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }
}
