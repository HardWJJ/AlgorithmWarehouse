package com.github.hardwjj.leetcode.group7.title2;

/**
 * 题：搜索：695. 矩阵中的连通分量数目 DFS（力扣）
 *
 * 题目描述
 *   给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 *   你可以假设网格的四个边均被水包围。
 *
 * 解题思路：
 * 示例 1:
 *  输入:
 *   11110
 *  11010
 *  11000
 *  00000
 * 示例 2:
 *  输入:
 *  11000
 *  11000
 *  00100
 *  00011
 *
 *  输出: 3
 *
 */
class Solution {

    private int m,n;

    // 定义四个方向
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null ||grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] != '0') {
                    dfs(grid, i, j);
                    num++;
                }
            }    
        }
        return num;
    }

    // 深度优先搜索，进入后将可达的路径都走一遍
    private void dfs(char[][] grid, int r, int c) {
        // 判断边界和是否可以走
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }
        // 设置为走过
        grid[r][c] = '0';
        for (int[] dirc : direction) {
            dfs(grid, r + dirc[0], c + dirc[1]);
        }
    }
}