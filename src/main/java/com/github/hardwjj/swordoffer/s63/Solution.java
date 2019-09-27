package com.github.hardwjj.swordoffer.s63;

/**
 * 题：股票的最大利润
 *
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 *
 * 解题思路：
 * 贪心算法，如果在第 i 轮卖出，则买入操作应该在 i 之前且价格最低。
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        // 初始化首个元素为最小价格
        int curMin = prices[0];
        int curMax = 0;
        for (int i = 1; i < prices.length; i++) {
            // 贪心选择：每次迭代都选取最小元素
            curMin = Math.min(curMin, prices[i]);
            // 将当前元素之前的最小元素与当前元素相比
            curMax = Math.max(prices[i] - curMin, curMax);
        }
        return curMax;
    }
}