package com.github.hardwjj.swordoffer.s60;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 题：n 个骰子的点数
 *
 * 把 n 个骰子扔在地上，求点数和为 s 的概率。
 *
 * 解题思路：
 *  使用动态规划，利用无后效性的特性将空间复杂度缩小为O(N)
 */
public class Solution {
    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        ArrayList<Map.Entry<Integer, Double>> list = new ArrayList<>();
        if(n < 1){
            return list;
        }
        int face = 6;
        int pointNum = n * face;
        long[][] dp = new long[2][pointNum + 1];
        // 初始化状态
        for (int i = 1; i <= face; i++) {
            dp[0][i] = 1;
        }

        int flag = 1;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            // 清空旧的状态
            for (int j = 1; j <= pointNum; j++) {
                dp[flag][j] = 0;
            }
            // 使用i个骰子最少的点数为i
            for (int j = i; j <= pointNum; j++) {
                // k表示把当前骰子
                    // 动态规划状态转移
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