package com.github.hardwjj.leetcode.group8.title1;

/**
 * 题：动态规划：70. 爬楼梯 DFS（力扣）
 *
 * 题目描述：有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
 *
 *  从下标为1的开始定义一个数组，由题得到递推公式 dp[i] = dp[i - 1] + dp[i - 2]
 *
 *  由于动态规划的无后效性，将空间复杂度进一步缩小为O(1)(只有两个元素)
 */
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        int pre2 = 2, pre1 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
}