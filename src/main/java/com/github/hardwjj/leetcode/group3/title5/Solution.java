package com.github.hardwjj.leetcode.group3.title5;

/**
 * 题：贪心算法：121. 买卖股票最大的收益（力扣）
 *
 * 题目描述
 *    一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 *
 * 示例 1:
 *      输入: [7,1,5,3,6,4]
 *      输出: 5
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 解题思路：
 *     贪心选择
 *     只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
 */
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       if(n ==  0){
           return 0;
       }
       // 买入时价格
       int min = prices[0];
       // 最大收益
       int max = 0;
        for (int i = 1; i < n; i++) {
            // 寻找最低买入
            if(min > prices[i]){
                min = prices[i];
            // 寻找最大收益
            }else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}