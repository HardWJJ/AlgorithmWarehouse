package com.github.hardwjj.leetcode.group7.title14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题：搜索：40. 含有相同元素的组合求和 DFS（力扣）
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] hasVisited = new boolean[candidates.length];
        bracking(temp, result, hasVisited, 0, target, candidates);
        return result;
    }

    private void bracking(List<Integer> temp, List<List<Integer>> result, boolean[] hasVisited, int start, int target, int[] candidates) {
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 如果i - 1与i相同只允许i - 1选择、i不选择的组合
            if(i != 0 && candidates[i - 1] == candidates[i] && !hasVisited[i - 1]) {
                continue;
            }

            if(candidates[i] <= target) {
               hasVisited[i] = true;
               temp.add(candidates[i]);
               bracking(temp, result, hasVisited, i + 1, target - candidates[i], candidates);
               temp.remove(temp.size() - 1);
               hasVisited[i] = false;
            }
        }
    }
}