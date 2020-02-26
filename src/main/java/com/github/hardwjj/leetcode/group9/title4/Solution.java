package com.github.hardwjj.leetcode.group9.title4;

/**
 * 题：数学：168. 26 进制（力扣）
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 *
 * 因为要通过ascii码方式计算值，所以输入值n-1
 */
class Solution {
    public String convertToTitle(int n) {
        if(n == 0){
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char)('A' + (n % 26));
    }
}