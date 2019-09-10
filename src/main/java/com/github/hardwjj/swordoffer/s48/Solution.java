package com.github.hardwjj.swordoffer.s48;

import java.util.Arrays;

/**
 * 题： 最长不含重复字符的子字符串
 *
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *
 *  解题思路：创建一个长度为a-z(26)的数组，字母a对应下标0， 字母b对象下标1，下标对应的存储值是当前字母的最大长度
 *  (0 - a1 / a1 - a2)
 */
class Solution {
    public static int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curIndex = 0; curIndex < str.length(); curIndex++) {
            int index = str.charAt(curIndex) - 'a';
            int preIndex = preIndexs[index];
            if(preIndex == -1 || curIndex - preIndex > curLen){
                curLen++;
            }else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curIndex - preIndex;
            }
            preIndexs[index] = curIndex;
        }
        maxLen = Math.max(curLen, maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        longestSubStringWithoutDuplication("arabcacfr");
    }
}