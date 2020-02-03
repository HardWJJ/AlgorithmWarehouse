package com.github.hardwjj.leetcode.group8.title7;

/**
 * 题：动态规划 矩阵路径：413. 数组中等差递增子区间的个数 DFS（力扣）
 *
 * dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。
 *
 * A = [0, 1, 2, 3, 4]
 *
 * return: 6, for 3 arithmetic slices in A:
 *
 * [0, 1, 2],
 * [1, 2, 3],
 * [0, 1, 2, 3],
 * [0, 1, 2, 3, 4],
 * [ 1, 2, 3, 4],
 * [2, 3, 4]
 *
 * dp[n] 表示以A[n]为结尾的等差区间个数
 * 当 A[i] - A[i-1] == A[i-1] - A[i-2]， [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。
 * 在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，再可以构成新的递增子区间。
 * 由于递增区间不一定以某个数结尾，所以需要累加
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        // dp[n] 表示以A[n]为结尾的等差区间个数
        int dp[] = new int[n];
        // 组成区间最少三个数字
        for (int i = 2; i < n; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int sum = 0;
        // 由于递增区间不一定以某个数结尾，所以需要累加
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}