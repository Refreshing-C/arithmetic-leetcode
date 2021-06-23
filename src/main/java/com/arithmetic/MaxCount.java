package com.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description
 */
public class MaxCount {
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "3", "4", "1", "5", "2", "6", "4", "2", "7", "9", "1", "7", "0"};
        String key = getMaxCount(arr);
        System.out.println(key);
    }

    private static String getMaxCount(String[] arr) {

        Map<String, Integer> keyValue = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (keyValue.containsKey(arr[i])) {
                keyValue.put(arr[i], keyValue.get(arr[i]) + 1);
            } else {
                keyValue.put(arr[i], 1);
            }
        }

        int maxCount = 0;
        String maxKey = "";

        for (String key : keyValue.keySet()) {
            if (keyValue.get(key) > maxCount) {
                maxCount = keyValue.get(key);
                maxKey = key;
            }
        }

        return maxKey;
    }
}
