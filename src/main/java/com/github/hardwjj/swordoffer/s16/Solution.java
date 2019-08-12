package com.github.hardwjj.swordoffer.s16;

/**
 * 题： 数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
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
    public double Power(double base, int exponent) {
        
  }
}