package com.github.hardwjj.leetcode.group1.title2;

/**
 * 题：双指针：   1. 两数平方和
 *     633. Sum of Square Numbers (Easy)
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 判断一个数是否为两个数的平方和。
 *
 * 解题思路：
 *   新建两个指针，一个从0开始，从前往后，一个从√￣input 从后往前，根据取值结果两个指针逐渐靠近
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j){
            int powSum = i * i + j * j;
            if(powSum == c){
                return true;
            }else if(powSum > c){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}