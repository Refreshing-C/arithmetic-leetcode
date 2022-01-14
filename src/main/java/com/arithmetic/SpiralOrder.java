package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Administrator
 * create: 2022-01-13 22:43
 * description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int all = rows * cols;

        boolean[][] visited = new boolean[rows][cols];

        int directionIndex = 0;
        int row = 0;
        int col = 0;

        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < all; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex  + 1)% 4;
            }

            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return res;
    }
}
