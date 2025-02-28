package com.nowcoder;

import java.util.ArrayList;

public class Test27 {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] arr = str.toCharArray();
        permute(list, arr, 0);
        list.sort(null);
        return list;
    }

    private void permute(ArrayList<String> list, char[] arr, int start) {
        if (start == arr.length - 1) {
            String result = String.valueOf(arr);
            if (!list.contains(result)) {
                list.add(result);
            }
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            permute(list, arr, start + 1);
            swap(arr, i, start);
        }
    }

    private void swap(char[] arr, int i, int start) {
        char temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }
}
