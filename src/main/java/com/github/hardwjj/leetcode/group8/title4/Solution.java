package com.github.hardwjj.leetcode.group8.title4;

/**
 * 题：动态规划 矩阵路径：64. 矩阵的最小路径和 DFS（力扣）
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 由于动态规划的无后效性，可以将dp使用的内存由O(m * n)变成O(n)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        // 存储每个阶段的最小路径
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算到达i,j前的最优解
                if(j == 0) {
                    // 只存储某一列的状态
                    dp[j] = dp[j];
                }else if(i == 0) {
                    dp[j] = dp[j - 1];
                }else {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
}