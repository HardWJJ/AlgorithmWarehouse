package com.github.hardwjj.leetcode.group3.title7;

/**
 * 题：贪心算法：605.种植花朵（力扣）
 *
 * 题目描述
 *    flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 *
 * 示例 1:
 *     输入: [7,1,5,3,6,4]
 *     输出: 7
 *     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *          随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 解题思路：
 *     贪心选择
 *     遍历传入数组，在能放花朵的地方尽量放在花朵，给后面的争取更大空间
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        // 找到 n 个位置也可以提前结束
        for (int i = 0; i < len && cnt < n; i++) {
            // 已经种了花朵，过滤
            if(flowerbed[i] == 1) {
                continue;
            }
            // 获取 i 位置上前后的种植情况
            // 考虑第一个位置和最后一个位置的极端情况
            int pre = i == 0? 0 : flowerbed[i - 1];
            int last = i == len - 1? 0: flowerbed[i + 1];
            // 前后都需要间隔
            if(pre == 0 && last == 0){
                flowerbed[i] = 1;
                cnt++;
            }
        }
        return cnt >= n;
    }
}