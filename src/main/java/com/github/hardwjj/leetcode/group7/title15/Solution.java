package com.github.hardwjj.leetcode.group7.title15;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：216. 1-9 数字的组合求和 DFS（力扣）
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> reuslt = new ArrayList<>();
        backtracking(k, n, 1, reuslt, temp);
        return reuslt;
    }

    private void backtracking(int k, int n, int start, List<List<Integer>> result, List<Integer> temp) {
        if(k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtracking(k - 1, n - i, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}