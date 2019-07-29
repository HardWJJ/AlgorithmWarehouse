package com.github.hardwjj.swordoffer.s61;

import java.util.Arrays;

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

        for (int i = cnt; i < numbers.length - 1; i++) {
            // 无法通过插入成为顺子
            if(numbers[i + 1] == numbers[i]){
                return false;
            }
            cnt -= (numbers[i + 1] - numbers[i]) - 1;
        }
        // 如果可抵消牌被用完或者有剩余
        return cnt >= 0;
    }
}