package com.github.hardwjj.swordoffer.s63;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int curMin = prices[0];
        int curMax = 0;
        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            curMax = Math.max(prices[i] - curMin, curMax);
        }
        return curMax;
    }
}