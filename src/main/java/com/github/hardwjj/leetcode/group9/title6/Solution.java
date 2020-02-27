package com.github.hardwjj.leetcode.group9.title6;

/**
 * 题：数学：67. 二进制加法（力扣）
 * a = "11"
 * b = "1"
 * Return "100".
 */
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length()  -1, carry = 0;
        // carry == 1 考虑最高位携带进制问题
        StringBuilder sb = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if(i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if(j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            sb.append(carry % 2);
            // 滿2进1
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}