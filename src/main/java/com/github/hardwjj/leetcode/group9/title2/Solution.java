package com.github.hardwjj.leetcode.group9.title2;

/**
 * 题：数学：504. 七进制数（力扣）
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"。
 */
class Solution {
    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }

        boolean isNegative = true;
        if(num < 0) {
            isNegative = false;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        String ret = sb.reverse().toString();
        if(isNegative) {
            return ret;
        }
        return "-" + ret;
    }
}