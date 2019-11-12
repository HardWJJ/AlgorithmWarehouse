package com.github.hardwjj.leetcode.group4.title0;

/**
 * 题：二分查找
 *
 * Input : [1,2,3,4,5]
 * key : 3
 * return the index : 2
 *
 *
 * 解题思路：
 *     二分查找  时间复杂度O(logn)
 *
 */
class Solution {

    /**
     * 标准二分
     */
    public int binarySearch0(int[] nums, int key) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == key){
                return mid;
            }else if(nums[mid] > key){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     */
    public int binarySearch1(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (nums[mid] > key) {
                high = mid - 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (nums[mid - 1] != key)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public int binarySearch2(int[] nums, int key) {
        int low = 0;
        int n =  nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (nums[mid] > key) {
                high = mid - 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (nums[mid + 1] != key)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public int binarySearch3(int[] nums, int key) {
        int low = 0;
        int n =  nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= key) {
                if((mid == 0) || nums[mid - 1] < key){
                    return mid;
                }else {
                    high = mid - 1;
                }
            } else {
               low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public int binarySearch4(int[] nums, int key) {
        int low = 0;
        int n =  nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > key) {
                high = mid - 1;
            } else {
                if((mid == n -1) || nums[mid + 1] > key){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}