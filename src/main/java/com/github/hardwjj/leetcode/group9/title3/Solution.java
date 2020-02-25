package com.github.hardwjj.leetcode.group9.title3;

/**
 * 题：数学：504. 七进制数（力扣）
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 */
public class Solution {

    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            // 无符号右移4位
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
