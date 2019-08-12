package com.github.hardwjj.swordoffer.s15;

/**
 * 题： 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 *
 * 解：
 *  解1：
 *  n&(n-1)
 *  该位运算去除 n 的位级表示中最低的那一位。
 *  n       : 10110100
 *  n-1     : 10110011
 *  n&(n-1) : 10110000
 * 时间复杂度：O(M)，其中 M 表示 1 的个数。
 *
 *  解2：
 *  Integer.bitCount()
 *
 */
public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0){
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}