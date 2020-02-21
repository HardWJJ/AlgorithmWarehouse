package com.github.hardwjj.leetcode.group8.title23;

/**
 * 题：动态规划 股票交易：714. 买卖股票的最佳时机含手续费 DFS（力扣）
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * 在最佳买卖股票时机含冷冻期的基础上，卖出股票时扣去手续费扣去冷冻期
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
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
            // 买入的当前股票的状态等于冷冻期状态 - 当前股票价格，而且卖出后不能立即买入
            buy[i] = Math.max(s2[i - 1], sell[i - 1]) - prices[i];
            // 买入后等待交易的状态，这里需要取最大值，因为卖出依赖于s1
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            // 卖出的状态等于之前买入的值与买入后等待交易的状态值的最大值与当前价格之和
            sell[i] = Math.max(s1[i - 1], buy[i - 1]) + prices[i] - fee;
            // 卖出后等待交易的状态为之前等待交易的状态与售出状态的最大值
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }
        // 返回第n个物品后售出与卖出后等待交易的状态的最大值
        return Math.max(sell[n - 1], s2[n - 1]);
    }
}