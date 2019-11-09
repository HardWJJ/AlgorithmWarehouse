package com.github.hardwjj.leetcode.group3.title9;

/**
 * 题：贪心算法：665. 修改一个数成为非递减数组（力扣）
 *
 * 题目描述
 *   判断一个数组是否能只修改一个数就成为非递减数组。
 *
 *   输入: [4,2,3]
 *   输出: True
 *   解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 解题思路：
 *     贪心选择
 *     先修改靠前的数，使 nums[i - 1] = nums[i]，如果修改 nums[i] = nums[i - 1] ，那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        // 记录不符合非递减的数量
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            // 符合条件过滤
            if(nums[i] >= nums[i - 1]) {
                continue;
            }
            // 记录不符合数量
            cnt++;
            // 此时， i - 2 和 i - 1 都大于 i，大于两个数，拿最大的数修改 i 位置数，如果修改 i - 1，则 i - 2 还是会大于 i - 1
            if(i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            // 先尝试修改 1 个数，修改 i - 1 位置数
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}