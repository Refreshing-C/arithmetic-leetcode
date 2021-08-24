package com.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 19045752
 * @create 2020/7/20
 * @description 找出数组中出现次数最多的元素
 */
public class MaxCountNum {
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "3", "4", "1", "5", "2", "6", "4", "2", "7", "9", "1", "7", "0"};
        String key = getMaxCount(arr);
        System.out.println(key);
    }

    private static String getMaxCount(String[] arr) {

        Map<String, Integer> keyValue = new HashMap<>(arr.length);
        for (String s : arr) {
            if (keyValue.containsKey(s)) {
                keyValue.put(s, keyValue.get(s) + 1);
            } else {
                keyValue.put(s, 1);
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
