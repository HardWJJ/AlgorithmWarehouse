package com.github.hardwjj.leetcode.group8.title16;

/**
 * 题：动态规划 0-1 背包：494. 改变一组数的正负号使得它们的和为一给定数 DFS（力扣）
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *  输入: nums: [1, 1, 1, 1, 1], S: 3
 *  输出: 5
 *  解释:
 *      -1+1+1+1+1 = 3
 *      +1-1+1+1+1 = 3
 *      +1+1-1+1+1 = 3
 *      +1+1+1-1+1 = 3
 *      +1+1+1+1-1 = 3
 *  一共有5种方法让最终目标和为3。
 *
 *  将数组分成两部分，P为使用+的和，N为使用-的和
 *  sum(P) - sum(N) = target
 *  sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *  2 * sum(P) = target + sum(nums)
 *  sum(P) = target + sum(nums) / 2
 *  如果枚举数组的元素使他们的和等于 (target + sum(nums)) / 2，就说明存在解
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = sum(nums);
        if(sum < S || (sum + S) % 2 != 0) {
            return 0;
        }
        int W = (sum  + S) / 2;
        int[] dp = new int[W + 1];
        // 哨兵，为S仅等于某个元素遍历做准备
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}