package com.github.hardwjj.leetcode.group4.title3;

/**
 * 题：二分查询：540. 有序数组的 Single Element （力扣）
 *
 * 题目描述
 *   给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
 *
 *   Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
 *   Output: 2
 *
 *  要求时间复杂度： O(log n)
 *
 * 解题思路：
 *     二分搜索
 *      假设 index 下标位置是数组中待查找的位置
 *      （下标从0开始）如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
 *      假设middle是二分后的结果下标，那么如果 nums[middle] == nums[middle + 1]，那么 index 所在的数组位置为 [middle + 2, h]， l = m + 2（尽快缩小范围）
 *      如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]， h = m（此时不能确认是成对的第二个元素或者是需要找的元素）
 *      由于h = m，为防止死循环 退出条件为 h < m
 *
 */
class Solution {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, hight = nums.length - 1;
        while (low < hight) {
            int middle = low + ((hight - low) >> 1);
            // 将二分后结果转为偶数，使low hight middle 都是偶数
            if(middle % 2 == 1){
                middle--;
            }
            if(nums[middle] == nums[middle + 1]){
                low = low + 2;
            }else {
                hight = middle;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8});
    }
}