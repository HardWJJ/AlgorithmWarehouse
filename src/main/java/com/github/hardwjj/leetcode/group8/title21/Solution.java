package com.github.hardwjj.leetcode.group8.title21;

/**
 * 题：动态规划 0-1 背包：139. 组合总和 DFS（力扣）
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *  nums = [1, 2, 3]
 *  target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 *
 * 由于物品可以选择任意次，所以当空间复杂度缩小的O(n)时不用担心某个物品的枚举被覆盖，可以直接从前往后
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target+ 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}