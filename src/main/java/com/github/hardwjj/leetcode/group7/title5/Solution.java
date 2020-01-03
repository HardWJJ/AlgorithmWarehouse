package com.github.hardwjj.leetcode.group7.title5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题：搜索：130. 能到达的太平洋和大西洋的区域 DFS（力扣）
 *
 * 题目描述
 *   给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *   规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *   请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 给定下面的 5x5 矩阵:
 *
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 *   *   *   *   *   大西洋
 *
 * 返回:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 */
class Solution {

    private int[][] dirction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int[][] matrix;

    private int m,n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return lists;
        }
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;

        // 记录太平洋走过区域
        boolean[][] canP = new boolean[m][n];
        // 记录大西洋走过区域
        boolean[][] canD = new boolean[m][n];

        // 从四个方向搜索所有可能流到的区域
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, canD);
            dfs(i, 0, canP);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canP);
            dfs(m - 1, i, canD);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 重合部分为都经过的版块
                if(canP[i][j] && canD[i][j]) {
                    lists.add(Arrays.asList(i, j));
                }
            }
        }
        return lists;
    }

    private void dfs(int r, int c, boolean[][] reach) {
        if(reach[r][c]) {
            return;
        }
        reach[r][c] = true;
        for (int[] d : dirction) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if(nextR < 0 || nextR >= m || nextC <0 || nextC >= n || matrix[nextR][nextC] < matrix[r][c]) {
                // 继续考察下一个方向
                continue;
            }

            // 深度优先遍历
            dfs(nextR, nextC, reach);
        }
    }
}