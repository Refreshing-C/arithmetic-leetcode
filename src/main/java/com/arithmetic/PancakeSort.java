package com.arithmetic;

import java.util.LinkedList;
import java.util.List;

/**
 * author: 19045752
 * create: 2021/6/13
 * description: 盘中有n块面积大小不一的烧饼，如何用一把锅铲进行若干次翻转，让这些烧饼的大小有序
 * method: 可以采用递归的方法，每次将未排序的烧饼中最大的一块翻到最底层，
 */
public class PancakeSort {
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }

    public void sort(int[] cakes, int n) {
        if (n == 1) {
            return;
        }
        int maxCake = 0;
        int maxCakeIndex = 0;

        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCake = cakes[i];
                maxCakeIndex = i;
            }
        }

        // 第一次翻转，将最大的烧饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // 第二次翻转，将最大的烧饼翻到最下面
        reverse(cakes, 0, n - 1);
        res.add(n);

        sort(cakes, n - 1);
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
