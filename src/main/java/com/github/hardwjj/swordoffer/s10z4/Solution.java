package com.github.hardwjj.swordoffer.s10z4;

import java.util.Arrays;

/**
 * 题： 变态跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 *
 * 解：
 * 动态规划
 */
public class Solution {
    public int JumpFloorII(int n) {
        int[] dp = new int[n];
        // 初始化所有台阶1种跳法
        Arrays.fill(dp, 1);
        // 每一层(i)都由前面(0 - i-1)层的任意一层跳上来
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j];
            }
        }
        return dp[n - 1];
    }
}