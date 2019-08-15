package com.github.hardwjj.swordoffer.s19;

/**
 * 题： 正则表达式匹配
 * 题目描述：
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 *
 * 解题思路：
 *  应该注意到，'.' 是用来当做一个任意字符，而 '*' 是用来重复前面的字符。这两个的作用不同，不能把 '.' 的作用和 '*' 进行类比，从而把它当成重复前面字符一次。
 *
 */
public class Solution {

    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        // 初始化dp
        for (int i = 1; i <= n; i++) {
            if(pattern[i - 1] == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果字符串相等或可以任意匹配
                if(str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pattern[j - 1] == '*'){
                    // 出现匹配前面任意次字符
                        // 如果任意字符前一个与当前待匹配正式串字符， 或者任意一个字符前面是 .，与之前情况类似，进行多方与，下一个状态推进，三种符合一种就行
                    if(pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.'){
                        // * 表示它前面的字符可以出现1次
                        dp[i][j] |= dp[i][j - 1];
                        // * 表示它前面的字符可以出现0次
                        dp[i][j] |= dp[i - 1][j];
                        // * 表示它前面的字符可以出现大于1次
                        dp[i][j] |= dp[i][j - 2];
                    }else {
                        // 为了保证记录失败
                        // * 表示它前面的字符可以出现大于1次
                        // * 表示它前面的字符可以出现1次
                        dp[i][j] =  dp[i][j - 1] && dp[i][j - 2] ;
                    }
                }
            }
        }
        return dp[m][n];
    }

}