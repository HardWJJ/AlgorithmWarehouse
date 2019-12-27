package com.github.hardwjj.leetcode.group7.title1;

/**
 * 题：搜索：695. 岛屿的最大面积 DFS（力扣）
 *
 * 题目描述
 *   给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着
 *   找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 解题思路：
 *      深度优先搜索，从每个节点开始进行深度优先搜索，当遇到非土地时回溯
 *
 */
class Solution {

    private int m,n;

    // 定义四个方向
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        // 值判断
        if(grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 穷举所有路径，如果相同区域内某个节点已经计算出最大面积，则区域内其他节点不需要继续深度搜索
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    // 深度优先搜索
    private int dfs(int[][] grid, int r, int c) {
        // 判断边界和是否可以走
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }
        // 设置为走过
        grid[r][c] = 0;
        int curArea = 1;
        for (int[] dirc : direction) {
            curArea += dfs(grid, r + dirc[0], c + dirc[1]);
        }
        // 不将grid[r][c]还原，从任意一条走遍历完所有土地就行，不需要从相同区域内选其他点
        return curArea;
    }
}