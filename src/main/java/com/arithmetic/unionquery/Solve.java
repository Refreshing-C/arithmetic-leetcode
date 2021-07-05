package com.arithmetic.unionquery;

/**
 * author: Administrator
 * create: 2021/6/27 0027
 * description: 有一个二维棋盘，放置了X和O，找到所有完全被X包围的O，把它们改为X
 * method: 放在棋盘边界的O必然不会被包围，和边界上的O相连接的O也不会被包围，那么可以使用一个dummy点
 *      和这些点相连，在遍历棋盘的时候，如果当前点不和dummy相连，那么就把它替换成X
 */
public class Solve {
    public void solve(char[][] board) {
        int m = board.length;

        if (m == 0) {
            return;
        }

        int n = board[0].length;

        UnionQuery uq = new UnionQuery(m * n + 1);
        // 虚拟节点
        int dummy = m * n;

        // 将棋盘第一列和最后一列的O与dummy相连
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uq.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uq.union(i * n + n - 1, dummy);
            }
        }

        // 将棋盘第一行和最后一行的O与dummy相连
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uq.union(i, dummy);
            }
            if (board[m - 1][i] == 'O') {
                uq.union((m - 1) * n + i, dummy);
            }
        }

        int[][] temp = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // 使用方向数组来遍历当前点的上下左右
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 'O') {
                    // 将此O与和它上下左右相连的O连接起来
                    for (int k = 0; k < 4; k++) {
                        int x = temp[k][0] + i;
                        int y = temp[k][1] + j;
                        if (board[x][y] == 'O') {
                            uq.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uq.connected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
