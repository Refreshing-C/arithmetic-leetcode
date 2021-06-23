package com.arithmetic.dfs;

/**
 * author: 19045752
 * create: 2021/5/27
 * description: 输入一个9×9的棋盘，空白格子用点号表示，要求在原地修改棋盘，将空白格子填上数字，得到一个可行解。
 * 每行 每列以及每一个3×3的小方格都不能有相同的数字出现。
 * method: 回溯算法 对每一个为点号的位置，用0-9逐一尝试，判断是否合法，合法则给当前位置填上数字，继续填下一个位置的数字，
 * 当当前行全部填满时，填下一行，所有行都填满后，返回结果。
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        int m = 9;
        int n = 9;

        if (col == m) {
            return backtrack(board, row + 1, 0);

        }

        if (row == n) {
            return true;
        }
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, row, col, ch)) {
                continue;
            }

            board[row][col] = ch;
            if (backtrack(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }
            if (board[i][col] == ch) {
                return false;
            }
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i / 3] == ch) {
                return false;
            }
        }
        return true;
    }

}
