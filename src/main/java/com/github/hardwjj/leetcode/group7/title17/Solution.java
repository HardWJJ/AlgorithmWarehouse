package com.github.hardwjj.leetcode.group7.title17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题：搜索：90. 含有相同元素求子集 DFS（力扣）
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            backtracking(nums, i, visited ,0, temp, result);
        }
        return result;
    }

    private void backtracking(int[] nums, int size, boolean[] visited ,int start, List<Integer> temp, List<List<Integer>> result) {
        if(size == temp.size()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
                temp.add(nums[i]);
                visited[i] = true;
                backtracking(nums, size, visited, i + 1, temp, result);
                visited[i] = false;
                temp.remove(temp.size() - 1);
        }
    }
}