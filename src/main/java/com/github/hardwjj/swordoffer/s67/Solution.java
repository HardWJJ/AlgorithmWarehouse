package com.github.hardwjj.swordoffer.s67;

/**
 * 题：把字符串转换成整数
 *
 * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
 *
 * Iuput:
 *  +2147483647
 *  1a33
 *
 * Output:
 *  2147483647
 *  0
 *
 * 解题思路：
 *      从高位到低位逐个遍历，高位*10 + (低位-'0')，类似递归后半步骤，自底向上，刚才开始还需要判断数的正负性
 */
public class Solution {
    public int StrToInt(String str) {
        // 判空
        if(str == null || str.length() == 0){
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';

        int ret = 0;

        // 遍历数组
        for (int i = 0; i < str.toCharArray().length; i++) {
            // 判断首个字符的正负性
            if(i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')){
                continue;
            }

            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }

            ret = ret * 10 + (str.charAt(i) - '0');
        }
        return isNegative == true ? -ret : ret;
    }
}