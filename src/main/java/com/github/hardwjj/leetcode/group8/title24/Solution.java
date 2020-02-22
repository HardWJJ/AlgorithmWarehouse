package com.github.hardwjj.leetcode.group8.title24;

/**
 * 题：动态规划 股票交易：583. 删除两个字符串的字符使它们相等 DFS（力扣）
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例 1:
 *  输入: "sea", "eat"
 *  输出: 2
 *  解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 *  可转化为最长公共子序列问题，求出两个字符串的最长公共子序列长度后，再将原来总长度减去最长公共子序列长度得到结果
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}