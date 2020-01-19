package com.github.hardwjj.leetcode.group7.title11;

/**
 * 题：搜索：47. 全排列 DFS（力扣）
 *
 * 题目描述
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 *  [
 *      [1,1,2],
 *      [1,2,1],
 *      [2,1,1]
 *  ]
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(temp, result, visited, nums);
        return result;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, int[] nums) {
        if(permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果后一个与前一个相同，且前一个未被访问则过滤，只留访问保留重复元素2、重复元素1顺序
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, visited, nums);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}