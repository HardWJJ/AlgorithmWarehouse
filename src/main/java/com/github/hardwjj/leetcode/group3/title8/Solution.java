package com.github.hardwjj.leetcode.group3.title8;

/**
 * 题：贪心算法：392. 判断是否为子序列（力扣）
 *
 * 题目描述
 *   s = "abc", t = "ahbgdc"
 *   Return true.
 *
 *   s = "axc", t = "ahbgdc"
 *   Return false.
 *
 *   字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 解题思路：
 *     贪心选择
 *     从前面的字符开始匹配，匹配后从已经匹配后的下一个位置开始继续匹配，如果某个字符无法匹配则返回false
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}