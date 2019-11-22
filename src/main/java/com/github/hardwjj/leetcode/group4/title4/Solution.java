package com.github.hardwjj.leetcode.group4.title4;

/**
 * 题：二分查询：278. 第一个错误的版本 （力扣）
 *
 * 题目描述
 *   给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，导致后面的版本都错误。可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。
 *
 *  给定 n = 5，并且 version = 4 是第一个错误的版本。
 *  调用 isBadVersion(3) -> false
 *  调用 isBadVersion(5) -> true
 *  调用 isBadVersion(4) -> true
 *  所以，4 是第一个错误的版本。 
 *
 * 解题思路：
 *     二分搜索
 *     类似于查找第一个值等于给定值的元素，如果没有匹配的返回二分的最左下标，应对只有一个数的情况
 */
public class Solution {
    public int firstBadVersion(int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) {
                if (mid == 0 || !isBadVersion(mid - 1)) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}