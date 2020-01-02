package com.github.hardwjj.leetcode.group7.title4;

/**
 * 题：搜索：130. 被围绕的区域 DFS（力扣）
 *
 * 题目描述
 *   给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *   找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解题思路：深度优先搜索，先以边界为启点进行深度优先搜索，搜索后再处理边界内部节点
 *
 */
class Solution {

    private int[][] dirction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int m, n;

    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;

        // 处理边界
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // 处理边界
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }

        if(board[r][c] == 'O') {
            board[r][c] = 'T';
        }

        for (int[] d : dirction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}