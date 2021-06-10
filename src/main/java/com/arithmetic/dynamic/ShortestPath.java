package com.arithmetic.dynamic;

/**
 * @author 19045752
 * @create 2020/7/17
 * @description
 */
public class ShortestPath {

    public static void main(String[] args) {
        int[][] m = {
                {0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 8, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}
        };

        System.out.println(minPath(m));
    }

    private static int minPath(int[][] matrix) {

        return process(matrix, matrix[0].length - 1);
    }

    private static int process(int[][] matrix, int i) {

        if (i == 0) {
            return 0;
        } else {
            int distance = 999;
            for (int j = 0; j < i; j++) {
                if (matrix[j][i] != 0) {
                    int tmpDistance = matrix[j][i] + process(matrix, j);
                    System.out.println("第" + j + "行 第" + i + "列");
                    if (tmpDistance < distance) {
                        distance = tmpDistance;
                    }
                }
            }
            return distance;
        }
    }
}
