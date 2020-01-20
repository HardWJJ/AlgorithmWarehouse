package com.github.hardwjj.leetcode.group7.title12;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：77. 组合 DFS（力扣）
 *
 * 题目描述
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 *   示例:
 *
 *   输入: n = 4, k = 2
 *   输出:
 *   [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   ]
 *
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtracking(temp, result, 1, k, n);
        return result;
    }

    private void backtracking(List<Integer> temp, List<List<Integer>> result, int start, int k, int n) {
        // 组合已经达到指定个数
        if(k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 剪枝，去掉重复以大的数字为开头的组合，如14与41去掉41
        for (int i = start; i <= n - k + 1; i++) {
            temp.add(i);
            backtracking(temp, result, i + 1, k - 1, n);
            temp.remove(temp.size() - 1);
        }
    }
}