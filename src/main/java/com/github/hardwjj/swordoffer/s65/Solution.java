package com.github.hardwjj.swordoffer.s65;

/**
 * 题：不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号。
 *
 * 解题思路：
 *  a ^ b 表示没有考虑进位的情况下两数的和  +  (a & b) << 1 就是进位。
 *  递归会终止的条件是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为 0，递归终止。
 *  在递归过程中在解相同的情况下问题规模b不断缩小，最后缩小为0，这个可以做为终止条件
 */
public class Solution {

    public static int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Add(7, 5);
    }

    // 0 1 0 1
    // 0 1 1 1

    // 0 0 1 0
    // 1 0 1 0

    // 1 0 0 0
    // 0 1 0 0

    // 1 1 0 0
    // 0 0 0 0

}
