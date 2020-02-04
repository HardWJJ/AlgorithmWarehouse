package com.github.hardwjj.leetcode.group8.title10;

/**
 * 题：动态规划 分割整数：91. 分割整数构成字母字符串 DFS（力扣）
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *  输入: "12"
 *  输出: 2
 *  解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // dp[x] 表示s的第x个字符可以解码的字母组合数
        int[] dp = new int[n + 1];
        // 特殊条件，配合判断第2个字符时，前两个字符可组合的情况
        dp[0] = 1;
        if(s.charAt(0) != '0') {
            dp[1] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // 判断能否组成10以上字母
            if(s.charAt(i - 2) != '0') {
                String temp = s.substring(i - 2, i);
                if(Integer.parseInt(temp) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}