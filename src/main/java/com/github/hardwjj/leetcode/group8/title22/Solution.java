package com.github.hardwjj.leetcode.group8.title22;

/**
 * 题：动态规划 股票交易：309.  最佳买卖股票时机含冷冻期 DFS（力扣）
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *  输入: [1,2,3,0,2]
 *  输出: 3
 *  解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // 买入后的状态
        int[] buy = new int[n];
        // 卖出后的状态
        int[] sell = new int[n];
        // 买入后等待交易的状态
        int[] s1 = new int[n];
        // 卖出后等待交易的状态，含冷冻期
        int[] s2 = new int[n];
        // 初始化买入第1支股票
        s1[0] = buy[0] = -prices[0];
        // 初始化卖出与卖出后等待交易的状态
        sell[0] = s2[0] = 0;
        for (int i = 1; i < n; i++) {
            // 买入的当前股票的状态等于冷冻期状态 - 当前股票价格
            buy[i] = s2[i - 1] - prices[i];
            // 买入后等待交易的状态，这里需要取最大值，因为卖出依赖于s1
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            // 卖出的状态等于之前买入的值与买入后等待交易的状态值的最大值与当前价格之和
            sell[i] = Math.max(s1[i - 1], buy[i - 1]) + prices[i];
            // 卖出后等待交易的状态为之前等待交易的状态与售出状态的最大值
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }
        // 返回第n个物品后售出与卖出后等待交易的状态的最大值
        return Math.max(sell[n - 1], s2[n - 1]);
    }
}