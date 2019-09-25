package com.github.hardwjj.swordoffer.s61;

import java.util.Arrays;

/**
 * 题：扑克牌顺子
 *
 * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 *
 * 解题思路：
 *  使用动态规划，利用无后效性的特性将空间复杂度缩小为O(N)
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }

        Arrays.sort(numbers);
        // 统计可以抵消其他牌的数量
        int cnt = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                cnt++;
            }
        }

        // 由于之前排了序所以癞子排都在最前面
        for (int i = cnt; i < numbers.length - 1; i++) {
            // 无法通过插入成为顺子
            if(numbers[i + 1] == numbers[i]){
                return false;
            }
            // 多减一保证顺序不减掉癞子的牌
            cnt -= (numbers[i + 1] - numbers[i]) - 1;
        }
        // 如果可抵消牌被用完或者有剩余
        return cnt >= 0;
    }
}