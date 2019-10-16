package com.github.hardwjj.leetcode.group1.title4;

/**
 * 题：双指针：   4. 回文字符串
 *     680. Valid Palindrome II (Easy)
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * 解题思路：
 *   题目描述：可以删除一个字符，判断是否能构成回文字符串。
 */
class Solution {

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                // 可以去掉一个字符
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}