package com.github.hardwjj.leetcode.group4.title1;

/**
 * 题：二分查询：69. Sqrt(x) （力扣）
 *
 * 题目描述
 *   实现 int sqrt(int x) 函数。
 *
 *  计算并返回 x 的平方根，其中 x 是非负整数。
 *
 *  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * Input: 4
 * Output: 2
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 *
 *
 * 解题思路：
 *     二分搜索
 *     一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
 *     对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
 */
class Solution {
    public static int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        int low = 1, high = x;
        while (low <= high){
            int middle = low + (high - low) / 2;
            int sqrt = x / middle;
            if(sqrt == middle){
                return middle;
            }else if(sqrt < middle){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
}