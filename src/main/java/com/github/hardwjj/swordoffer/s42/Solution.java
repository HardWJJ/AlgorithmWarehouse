package com.github.hardwjj.swordoffer.s42;

/**
 * 题： 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 *
 *  解题思路：
 *     初始化一个最大值和总数和，遍历数组，遍历期间更新总数和和最大值。
 *
 */
public class Solution {

    public int FindGreatestSumOfSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum <= 0 ? nums[i] : nums[i] + sum;
            max = Math.max(sum, max);
        }
        return max;
    }
}