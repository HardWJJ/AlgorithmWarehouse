package com.github.hardwjj.leetcode.group8.title5;

import java.util.Arrays;

/**
 * 题：动态规划 矩阵路径：62. 矩阵的总路径数 DFS（力扣）
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 只能向下或向右行走
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[n] 到达n位置的路径数为两个方向之和
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}