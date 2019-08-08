package com.github.hardwjj.swordoffer.s4;

/**
 * 题：给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * 解：时间复杂度O(m + n)，空间复杂度O(1)
 * 待查询的数字，小于的它的数一定在左边，大于它的数一定在下边。
 * 从右上角开始查找，根据待查询元素与当前元素关系来缩小区间，当前元素查找区间为左下角所有元素。
 *
 */

public class Solution {

    public boolean Find(int target, int [][] array) {
        // 错误参数判断
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        // 从右上角开始搜索
        int r = 0, c = array[0].length - 1;
        while (r <= array.length - 1 && c >= 0){
            // 往左边搜索
            if(target < array[r][c]){
                c--;
            // 往下搜索
            }else if(target > array[r][c]){
                r++;
             // 相等元素返回
            }else {
               return true;
            }
        }
        return false;
    }

}