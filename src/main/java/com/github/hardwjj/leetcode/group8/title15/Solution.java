package com.github.hardwjj.leetcode.group8.title15;

/**
 * 题：动态规划 0-1 背包：416. 划分数组为和相等的两部分 DFS（力扣）
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 可以看成两个0 1 背包，dp[n]表示有没有存在能拼成n的数组
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        // 不能分割数组
        int total = sum(nums);
        if(total % 2 != 0) {
            return false;
        }
        int m = total / 2;
        boolean[] dp = new boolean[m + 1];
        // 哨兵节点
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = m; j >= nums[i]; j--) {
                // 不选 dp[j] 或者选 dp[j - nums[i]],如果值小于nums[i]，不用判断，肯定选不了
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        // 如果全部枚举完后，dp[n]存在，则答案有解
        return dp[m];
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}