package com.arithmetic;

import java.util.HashMap;
import java.util.Random;

/**
 * author: Administrator
 * create: 2021/5/16 0016
 * description: 给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
 * method: 将[0, n)看作一个数组，将黑名单中的数组映射到数组末尾，每次随机访问数组中黑名单之前的几位数字，如果是黑名单数字，则映射到末尾相应位置的数字。
 *      需要考虑两个问题，1：末尾数字是黑名单数字，在建立映射时，应跳过该末尾数字。
 *      2：黑名单数字在数组中黑名单映射部分，则应跳过该黑名单数字。
 */
public class RandomNotInBlackList {
    HashMap<Integer, Integer> mapping = new HashMap<>();
    int noBlackList;
    Random random = new Random();

    public RandomNotInBlackList(int n, int[] blacklist) {
        for (int i : blacklist) {
            mapping.put(i, 666);
        }

        noBlackList = n - blacklist.length;
        int lastIndex = n - 1;
        for (int b : blacklist) {
            if (b >= noBlackList) {
                continue;
            }
            while (mapping.containsKey(lastIndex)) {
                lastIndex--;
            }
            mapping.put(b, lastIndex);
            lastIndex--;
        }

    }

    public int pick() {
       int index = random.nextInt(noBlackList);
       if (mapping.containsKey(index)) {
           return mapping.get(index);
       }
       return index;
    }

}
