package com.github.hardwjj.leetcode.group8.title17;

/**
 * 题：动态规划 0-1 背包：322 找零钱的最少硬币数 DFS（力扣）
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *  输入: coins = [1, 2, 5], amount = 11
 *  输出: 3
 *  解释: 11 = 5 + 5 + 1
 * 示例 2:
 *  输入: coins = [2], amount = 3
 *  输出: -1
 *  说明:
 *  你可以认为每种硬币的数量是无限的。
 *
 *  还是可以将空间缩小为O(n)，但是因为数量限制，也就是dp[x]的值不限制，
 *  所以可以基于最新的最优解（如果在枚举第i个物品，可以不用考虑前面基于第i个物品求得的dp[x - i]的值）来推导，不需要从后往前推导
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if(i == coin) {
                    // 更新最小数量
                    dp[i] = 1;
                } else if(dp[i] == 0 && dp[i - coin] != 0) {
                    // 因为值需要的是最小值，该等式不能与三合并
                    dp[i] = dp[i - coin] + 1;
                } else if(dp[i - coin] != 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0? -1: dp[amount];
    }
}