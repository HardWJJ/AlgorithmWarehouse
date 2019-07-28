package com.github.hardwjj.swordoffer.sixty;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        ArrayList<Map.Entry<Integer, Double>> list = new ArrayList<>();
        if(n < 1){
            return list;
        }
        int face = 6;
        int pointNum = n * face;
        long[][] dp = new long[2][pointNum + 1];
        for (int i = 1; i <= face; i++) {
            dp[0][i] = 1;
        }

        int flag = 1;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 1; j <= pointNum; j++) {
                dp[flag][j] = 0;
            }

            for (int j = i; j <= pointNum; j++) {
                // k表示把当前骰子
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }

        double totalNum = Math.pow(6, n);
        for (int i = n; i <= pointNum; i++) {
            list.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Map.Entry<Integer,Double>> list = dicesSum(7);
        System.out.println(list);
    }
}