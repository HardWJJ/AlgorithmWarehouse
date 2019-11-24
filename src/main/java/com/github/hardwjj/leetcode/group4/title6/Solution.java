package com.github.hardwjj.leetcode.group4.title6;

/**
 * 题：二分查询：34. 在排序数组中查找元素的第一个和最后一个位置 （力扣）
 *
 * 题目描述
 *   给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。如果数组中不存在目标值，返回 [-1, -1]。
 *   时间复杂度必须 O(log n)
 *
 *  示例 1:
 *      输入: nums = [5,7,7,8,8,10], target = 8
 *      输出: [3,4]
 *
 * 解题思路：
 *     二分搜索
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index1 = binarySearch1(nums, target);
        int index2 = binarySearch2(nums, target);
        if(index1 == -1){
            return new int[]{-1, -1};
        }
        return new int[]{index1, index2};
    }

    /**
     * 查找最后一个值等于给定值的下标
     */
    public int binarySearch2(int[] nums, int target) {
        int low = 0;
        int n =  nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (nums[mid + 1] != target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的下标
     */
    public int binarySearch1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (nums[mid - 1] != target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}