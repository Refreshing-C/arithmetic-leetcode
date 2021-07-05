package com.arithmetic;

import java.util.LinkedList;

/**
 * @author 19045752
 * @create 2020/7/16
 * @description
 */
public final class JosephRing {

    private JosephRing() {
    }

    public static void main(String[] args) {
        ring(10, 3);
    }

    private static void ring(int n, int m) {
        LinkedList<Integer> killRing = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            killRing.add(i);
        }

        int k = 2;
        int element;
        int i = 0;
        for (; i < k; i++) {
            element = killRing.poll();
            killRing.add(element);
        }

        i = 1;
        while (killRing.size() > 0) {
            element = killRing.poll();
            if (i < m) {
                killRing.add(element);
                i++;
            } else {
                i = 1;
                System.out.println(element + " have been killed");
            }
        }
    }
}
