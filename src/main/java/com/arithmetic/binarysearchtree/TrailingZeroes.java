package com.arithmetic.binarysearchtree;

/**
 * author: 19045752
 * create: 2021/6/2
 * description: 输入一个非负整数n，请计算阶乘n!的结果末尾有几个0
 * method: 要计算有多少个0，其实是计算能分解出多少个5，5可以分解出1个5，25可以分解出2个5，125可以分解出3个5...
 *      那么分别计算能分解出多少个5，25，125...即可知道有多少个0
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        int division = 5;
        while (division <= n) {
            res += n / division;
            division *= 5;
        }
        return res;
    }
}
