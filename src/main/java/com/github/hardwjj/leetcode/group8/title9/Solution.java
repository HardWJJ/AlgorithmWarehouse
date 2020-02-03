package com.github.hardwjj.leetcode.group8.title9;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：动态规划 分割整数：279. 按平方数来分割整数 DFS（力扣）
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * dp[n] 表示n从1到n中完全平方数最少的个数
 * dp[n] 可从 dp[1 ~ n-1] 中递推
 */
class Solution {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        List<Integer> squareList = generateList(n);
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < squareList.size(); j++) {
                // 相加大小已经超过i
                if(squareList.get(j) > i) {
                    break;
                }
                min = Math.min(min, dp[i - squareList.get(j)] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    // 生成 1 4 9 16
    private static List<Integer> generateList(int n) {
        int d = 3;
        int square = 1;
        List<Integer> result = new ArrayList<>();
        while (square <= n) {
            result.add(square);
            square += d;
            d += 2;
        }
        return result;
    }
}