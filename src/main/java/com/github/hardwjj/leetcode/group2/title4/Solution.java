package com.github.hardwjj.leetcode.group2.title4;

/**
 * 题：排序：荷兰国旗问题
 * 荷兰国旗包含三种颜色：红、白、蓝。
 *
 * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
 * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，
 * 而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
 *
 *  1. 按颜色进行排序 75. Sort Colors (Medium)
 *  Input: [2,0,2,1,1,0]
 *  Output: [0,0,1,1,2,2]
 *
 *  题目描述：只有 0/1/2 三种颜色。
 *
 * 解题思路：
 *     按照快排进行一次分区的思想，将小于基准值的都放基准值左边，将大于基准值的都放基准值右边，然后将基准值放中间 =》
 *     将小于1的值（所有0）放1的左边，将大于1的值（所有2）放1的右边，这里所有的1都类似基准值
 */
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two){
            if(nums[one] == 0){
                // 将 0 值放到 1 的左边
                swap(nums, one++, ++zero);
            }else if(nums[one] == 2){
                // 将 2 值放到 1 的右边，one值回到未确认新值，下标不变更
                swap(nums, one, --two);
            }else {
                // 确认一个基准值，继续确认下一个
                one++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}