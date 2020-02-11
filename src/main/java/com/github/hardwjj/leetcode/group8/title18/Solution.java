package com.github.hardwjj.leetcode.group8.title18;

/**
 * 题：动态规划 0-1 背包：474. 01 字符构成最多的字符串 DFS（力扣）
 * <p>
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * 注意:
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * <p>
 * 将原本动态规划所需要的二维数组再升高为多维数组
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];

        int zero, one;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            zero = 0;
            one = 0;
            for (char aChar : chars) {
                if (aChar == '0') {
                    zero++;
                } else {
                    one++;
                }
            }

            // 类似一维数组从后往前避免之前计算好元素被覆盖
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}