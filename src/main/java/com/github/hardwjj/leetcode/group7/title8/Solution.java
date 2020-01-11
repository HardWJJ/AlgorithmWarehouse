package com.github.hardwjj.leetcode.group7.title8;

/**
 * 题：搜索：79. 单词搜索. 在矩阵中寻找字符串 DFS（力扣）
 *
 * 题目描述
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *  board =
 *     [
 *      ['A','B','C','E'],
 *      ['S','F','C','S'],
 *      ['A','D','E','E']
 *      ]
 *  给定 word = "ABCCED", 返回 true.
 *  给定 word = "SEE", 返回 true.
 *  给定 word = "ABCB", 返回 false.
 *
 *  dfs，深度优先搜索时加上回溯
 */
class Solution {

    private final static int[][] dircetion = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n, m;

    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return true;
        }

        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        n = board.length;
        m = board[0].length;
        // 记录访问过的数组
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(backtracking(0, visited, board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(int curLen, boolean[][] visited, char[][] board, String word, int i, int j) {
        if(word.length() == curLen) {
            return true;
        }

        if(i < 0 || j < 0 || i > n - 1 || j > m -1 || visited[i][j]) {
            return false;
        }

        if(board[i][j] != word.charAt(curLen)) {
            return false;
        }

        visited[i][j] = true;
        for (int[] dir : dircetion) {
            if(backtracking(curLen + 1, visited, board, word, i + dir[0], j + dir[1])) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}