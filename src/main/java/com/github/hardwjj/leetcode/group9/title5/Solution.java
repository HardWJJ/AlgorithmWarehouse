package com.github.hardwjj.leetcode.group9.title5;

/**
 * 题：数学：172. 阶乘后的零（力扣）
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5
 * 0由2*5得出，只要找有多个5即可
 */
class Solution {
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}