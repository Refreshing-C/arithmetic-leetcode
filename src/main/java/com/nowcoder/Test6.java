package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Test6 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(arr, size);
        System.out.println(list);

    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        int[] a = new int[size];
        int[] b = new int[size];
        ArrayList<Integer> list = new ArrayList<>();

        //����һ�����ݷ��봰����
        for (int i = 0; i < size; i++) {
            a[i] = num[i];
            b[i] = num[i];
        }
        Arrays.sort(b);
        list.add(b[size - 1]);


        //���´����е�ֵ
        for (int j = size; j < num.length; j++) {
			System.arraycopy(a, 1, a, 0, size - 1);
            a[size - 1] = num[j];
            System.arraycopy(a, 0, b, 0, size);
            Arrays.sort(b);
            list.add(b[size - 1]);
        }

        return list;
    }

}
