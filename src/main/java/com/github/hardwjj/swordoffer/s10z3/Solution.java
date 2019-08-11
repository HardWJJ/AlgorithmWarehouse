package com.github.hardwjj.swordoffer.s10z3;

/**
 * 题： 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 *
 *
 * 解：
 * 当 n = 1 时，只有一种跳法
 * 当 n = 2 时，有两种跳法
 * 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。而 n-1 和 n-2 阶台阶的跳法可以看成子问题，
 * 该问题的递推公式为：
 *
 *  f(n) {
 *       1    n = 1
 *       2    n = 2
 *       f(n - 1)+f(n - 2) n > 1
 *  }
 *
 */
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