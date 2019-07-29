package com.github.hardwjj.swordoffer.s64;

public class Solution {

    public int Sum_Solution(int n) {
        int sum = n;
        // 左边为递归终止
        boolean result = n > 0 && (sum = sum + Sum_Solution(n - 1)) > 0;
        return sum;
    }
}