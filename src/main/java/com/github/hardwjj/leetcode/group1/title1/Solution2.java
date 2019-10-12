package com.github.hardwjj.leetcode.group1.title1;


/**
 * 题：双指针：   1. 有序数组的 Two Sum
 *     167. 两数之和 II - 输入有序数组
 *
 * 在有序数组中找出两个数，使它们的和为 target。
 *
 *
 *
 * 解题思路：
 *  使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 *
 *  - 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 *  - 如果 sum > target，移动较大的元素，使 sum 变小一些；
 *  - 如果 sum < target，移动较小的元素，使 sum 变大一些。
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}