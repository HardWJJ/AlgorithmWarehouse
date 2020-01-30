package com.github.hardwjj.leetcode.group7.title13;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：39. 组合求和 DFS（力扣）
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 *
 *
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracing(candidates, 0, target, result, temp);
        return result;
    }

    // 回溯
    private void backtracing(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> temp) {
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                temp.add(candidates[i]);
                backtracing(candidates, i, target - candidates[i], result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}