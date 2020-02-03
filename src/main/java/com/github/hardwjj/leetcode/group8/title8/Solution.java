package com.github.hardwjj.leetcode.group8.title8;

/**
 * 题：动态规划 分割整数：62. 分割整数的最大乘积 DFS（力扣）
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *  输入: 2
 *  输出: 1
 *  解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 *  输入: 10
 *  输出: 36
 *  解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 */
class Solution {
    public int integerBreak(int n) {
        // dp[x] 表示 整数x的最大乘积
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 比较dp[i - j] 和 把 i - j 加入计算时两个的最大乘积
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}