package com.nowcoder;

/**
 * 遍历二维数组，找到目标值
 */
public class FindInTwoDimensionalArray {

    public boolean Find(int target, int[][] array) {

        for (int[] inner : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (inner[j] == target) {
                    return true;
                }
            }
        }
        return false;

    }
}
