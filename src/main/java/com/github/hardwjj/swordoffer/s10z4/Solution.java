package com.github.hardwjj.swordoffer.s10z4;

import java.util.Arrays;

public class Solution {
    public int JumpFloorII(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j];
            }
        }
        return dp[n - 1];
    }
}