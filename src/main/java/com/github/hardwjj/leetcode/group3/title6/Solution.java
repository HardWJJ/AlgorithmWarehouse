package com.github.hardwjj.leetcode.group3.title6;

/**
 * 题：贪心算法：122. 买卖股票的最大收益 II（力扣）
 *
 * 题目描述
 *    可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
 *
 * 示例 1:
 *     输入: [7,1,5,3,6,4]
 *     输出: 7
 *     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *          随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 解题思路：
 *     贪心选择
 *     [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
 *     当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i -1]){
                sum += (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }
}