package com.arithmetic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: Administrator
 * create: 2021/5/20 0020
 * description:
 */
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<String> board = new ArrayList<>();
        String row = generateStringN(n);
        for (int i = 0; i < n; i++) {
            board.add(row);
        }

        backtrack(board, 0);
        return res;

    }

    /**
     * 路径：board中小于row的那些行都已经成功的放置了皇后
     * 选择列表：第row行的每一列都是放置皇后的选择
     * 终止条件：row超过了board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board.set(row, generateQueen(board.get(row), col));
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board.set(row, board.get(row).replace('Q', '.'));
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后冲突
        for (String s : board) {
            if (s.charAt(col) == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private String generateStringN(int n) {
        char[] row = new char[n];
        Arrays.fill(row, '.');
        return new String(row);
    }

    public String generateQueen(String s, int index) {
        char[] tmp = s.toCharArray();
        tmp[index] = 'Q';
        return String.valueOf(tmp);
    }

}
