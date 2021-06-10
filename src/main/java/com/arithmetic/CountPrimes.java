package com.arithmetic;

import java.util.Arrays;

/**
 * author: Administrator
 * create: 2021/6/2 0002
 * description: 给你一个数字n，返回[2,n)中素数的个数
 * method: 在遍历的过程中，使用每个数来判断n中有没有该数的倍数，如果有则将对应的数置为非素数，最后总计下未被标记的数字极为素数
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j+= i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean b : isPrim) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}
