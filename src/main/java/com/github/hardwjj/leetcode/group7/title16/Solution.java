package com.github.hardwjj.leetcode.group7.title16;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：78. 子集 DFS（力扣）
 *
 * 找出集合的所有子集，子集不能重复，[1, 2] 和 [2, 1] 这种子集算重复
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtraing(0, i, temp, result, nums);
        }
        return result;
    }

    private void backtraing(int start, int size, List<Integer> temp, List<List<Integer>> result, int[] nums) {
        if(temp.size() == size) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtraing(i + 1, size, temp, result, nums);
            temp.remove(temp.size() - 1);
        }
    }
}