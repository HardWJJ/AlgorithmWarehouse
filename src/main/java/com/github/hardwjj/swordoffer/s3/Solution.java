package com.github.hardwjj.swordoffer.s3;


/**
 * 题：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 *
 * 解：要求时间复杂度为O(n)，空间复杂度O(1)
 * 可以将值为i的元素放到下标为i的位置上，放置之前先判断下标为i位置的元素是否已经是i，
 * 如果是则已经重复返回
 * 如果不是则将值为i的元素与下标为i的元素互换
 *
 */

public class Solution {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 0){
            return false;
        }

        for (int i = 0; i < length; i++) {
            // 每次直到对应下标i对应元素i才退出
            while (i != numbers[i]){
                // 如果对应下标已经存在该元素
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }

                swap(numbers, numbers[i], i);
            }
        }
        return false;
    }

    private void swap(int numbers[], int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}