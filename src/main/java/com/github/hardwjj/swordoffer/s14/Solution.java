package com.github.hardwjj.swordoffer.s14;

/**
 * 题： 剪绳子
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 * n = 2
 * return 1 (2 = 1 + 1)
 *
 * n = 10
 * return 36 (10 = 3 + 3 + 4)
 *
 * 解：
 *  贪心算法：
 *      尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
 *  动态规划：
 *      每一次状态值由上一次推导
 *      当n为i时，最大值可能为i*i减去某个数   例：这个数为3时(1*2)
 *               也可能是i*某个数对应最大值   例：这个数为6时(3*3)
 *       i为6时 依次递推 1 5 , 2 4, 3 3
 *
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 当前两种情况的最大值与之前的最大值比较
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}