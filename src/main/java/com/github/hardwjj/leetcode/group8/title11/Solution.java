package com.github.hardwjj.leetcode.group8.title11;

import java.util.Arrays;

/**
 * 题：动态规划 最长递增子序列：300. 最长递增子序列 DFS（力扣）
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 *
 */
class Solution {

    // 时间复杂度为O(n^2)
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        // dp[x] 存储的是在以nums[x]为结尾的nums[1 - x] 序列中，最长递增序列长度
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            // 如果某个枚举数不符合递增序列条件，则给与初始化值 1
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    // 由于最长递增序列dp[x] 不一定是nums[x]结尾，所以需要全部遍历
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    // 时间复杂度为O(nlogn)
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int len = 0;
        for (int num : nums) {
            int result = binarySearch(tail, len - 1, num);
            // 没有找到符合元素
            if(result == -1) {
                tail[len] = num;
                len++;
            }else {
                tail[result] = num;
            }
        }
        return len;
    }

    // 在nums数组中寻找第一个大于等于num的数
    private int binarySearch(int[] nums, int height, int num) {
        int min = 0;
        while (min <= height) {
            int middle = min + ((height - min) >> 1);
            if(nums[middle] >= num) {
                if(middle == 0 || nums[middle - 1] < num) {
                    return middle;
                }else {
                    height = middle - 1;
                }
            }else {
                min = middle + 1;
            }
        }
        return -1;
    }
}