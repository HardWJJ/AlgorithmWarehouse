package com.github.hardwjj.leetcode.group5.title1;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：分支：241. 为运算表达式设计优先级 （力扣）
 *
 * 题目描述
 *   给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 * 解题思路：
 *      分治，先进行划分，对划分好的区间使用相同的求解方法，分治不同于动态规划，使用分治法划分的区间，区间和区间之间是没有关联的
 */
class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                // 左区间可能的所有结果，以区间为边界进行划分
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                // 右区间可能的所有结果，以区间为边界进行划分
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // 遍历所有可能的结果进行运算
                for (int l : left) {
                    for (int r : right) {
                        switch (c){
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        // 没有运算符号的情况
        if(ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}