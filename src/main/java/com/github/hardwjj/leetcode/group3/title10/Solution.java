package com.github.hardwjj.leetcode.group3.title10;

/**
 * 题：贪心算法：53. 最大子序和（力扣）
 *
 * 题目描述
 *   给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *   输入: [-2,1,-3,4,-1,2,1,-5,4],
 *   输出: 6
 *   解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 解题思路：
 *     贪心选择
 *     尽可能的选择，当当前子序和为负数时，重新开始统计
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0? preSum + nums[i] : nums[i];
            maxSum = Math.max(preSum, maxSum);
        }
        return maxSum;
    }
}