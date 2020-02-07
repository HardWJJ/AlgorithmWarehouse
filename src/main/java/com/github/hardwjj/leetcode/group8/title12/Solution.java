package com.github.hardwjj.leetcode.group8.title12;

import java.util.Arrays;

/**
 * 题：动态规划 最长递增子序列：300. 一组整数对能够构成的最长链 DFS（力扣）
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 *  输入: [[1,2], [2,3], [3,4]]
 *  输出: 2
 *  解释: 最长的数对链是 [1,2] -> [3,4]
 *
 *
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs[0] == null) {
            return 0;
        }
        // 按照数对首个元素进行排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        // dp[x] 存储到达第 x + 1 个元素的最长递增序列
        int[] dp = new int[n];
        // 将所有的元素长度都初始化为1，假设自己就是当前最长链
        Arrays.fill(dp, 1);
        // 从第2个元素开始遍历
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前遍历的数对的第一个元素大于这个数对之前的第j个数对则进行长度累加
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}