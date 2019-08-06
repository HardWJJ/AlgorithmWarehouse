package com.github.hardwjj.swordoffer.s10z3;

public class Solution {
    public int JumpFloor(int n) {
        if(n <= 2){
            return n;
        }

        int pre1 = 1, pre2 = 2, result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}