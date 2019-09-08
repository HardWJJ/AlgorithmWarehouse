package com.github.hardwjj.swordoffer.s46;

/**
 * 题： 把数字翻译成字符串
 *
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  解题思路：类似爬楼梯问题，可用动态规划，无后效性可以将空间复杂度缩小为O(n)。
 *  由于题目要求从1开始，所以要注意0的过滤
 *
 */
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            String one = s.substring(i - 1, i);
            if(!"0".equals(one)){
                dp[i] = dp[i - 1] + dp[i];
            }
            if('0' == s.charAt(i - 2)){
                continue;
            }
            String two = s.substring(i - 2, i);
            if(Integer.parseInt(two) <= 26){
                dp[i] = dp[i - 2] + dp[i];
            }
        }
        return dp[n];
    }
}