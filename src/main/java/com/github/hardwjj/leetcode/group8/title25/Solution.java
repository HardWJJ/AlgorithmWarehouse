package com.github.hardwjj.leetcode.group8.title25;

/**
 * 题：动态规划 字符串编辑：714. 复制粘贴字符 DFS（力扣）
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 *   输入: 3
 *   输出: 3
 *   解释:
 *   最初, 我们只有一个字符 'A'。
 *   第 1 步, 我们使用 Copy All 操作。
 *   第 2 步, 我们使用 Paste 操作来获得 'AA'。
 *   第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 */
class Solution {
    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }

        // dp[x] 为到达x的最小操作次数
        int[] dp = new int[n + 1];
        dp[1] = 0;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            // 初始化为最大操作次数，都是使用A复制
            dp[i] = i;
            // 表示复制次数
            for (int j = 2; j <= limit; j++) {
                // 表示可以使用对应的复制次数，操作次数越少越好，所以从2开始
                if(i % j == 0) {
                    // dp[i] = (i / j)的对应copy + j的复制次数
                    dp[i] = dp[i / j] + dp[j];
                }
            }
        }
        return dp[n];
    }
}