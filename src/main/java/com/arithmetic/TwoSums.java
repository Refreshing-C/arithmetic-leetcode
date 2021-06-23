package com.arithmetic;

import com.arithmetic.array.QuickSort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description
 */
public class TwoSums {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int target = 2;
        int[] twoSums = getTwoSums(arr, target);

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
}
