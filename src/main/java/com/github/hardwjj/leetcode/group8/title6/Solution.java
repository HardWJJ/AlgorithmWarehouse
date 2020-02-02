package com.github.hardwjj.leetcode.group8.title6;

/**
 * 题：动态规划 数组区间：303. 数组区间和 DFS（力扣）
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *  sumRange(0, 2) -> 1
 *  sumRange(2, 5) -> -1
 *  sumRange(0, 5) -> -3
 *
 *  求解区间的和 i - j 可以转换为 sum[j + 1] - sum[i], sum[j + 1] 表示 0 - j, sum[i] 表示 0 - i - 1;
 */
class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}