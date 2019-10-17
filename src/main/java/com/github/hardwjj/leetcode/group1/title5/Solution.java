package com.github.hardwjj.leetcode.group1.title5;

/**
 * 题：双指针：   5. 归并两个有序数组
 *     88. Merge Sorted Array (Easy)
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * 把归并结果存到第一个数组上。
 *
 *
 * 解题思路：
 *   需要从尾开始遍历，否则可能覆盖到之前还未归并的值。
 */
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0){
            // 数组1已遍历完
            if(index1 < 0){
                nums1[indexMerge--] = nums2[index2--];
            // 数组2已遍历完
            }else if(index2 < 0){
                nums1[indexMerge--] = nums1[index1--];
            // index1 > index2
            }else if(nums1[index1] > nums2[index2]){
                nums1[indexMerge--] = nums1[index1--];
            // index2 > index1
            }else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}