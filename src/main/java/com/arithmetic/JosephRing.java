package com.arithmetic;

import java.util.LinkedList;

/**
 * @author 19045752
 * @create 2020/7/16
 * @description 有N个人依次编号1，2...n，从第k个人开始报数，数到m的那个人出列，他的下一个人又从1开始报数，
 *          数到m的那个人又出列，依次重复下去，直到所有人全部出列。
 */
public final class JosephRing {

    private JosephRing() {
    }

    public static void main(String[] args) {
        ring(10, 3, 2);
//        ring(15, 5, 3);
    }

    private static void ring(int n, int m, int k) {
        LinkedList<Integer> killRing = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            killRing.add(i);
        }

        int element;
        for (int j = 1; j < k; j++) {
            element = killRing.poll();
            killRing.add(element);
        }

        int index = 1;
        while (killRing.size() > 0) {
            element = killRing.poll();
            if (index < m) {
                killRing.add(element);
                index++;
            } else {
                index = 1;
                System.out.println(element + " have been killed");
            }
        }
    }
}
