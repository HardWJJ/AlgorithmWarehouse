package com.github.hardwjj.swordoffer.s53;

/**
 * 题：数字在排序数组中出现的次数
 *
 * 解题思路：
 *
 *  二分查找第一个等于指定数的下标 O(logn)
 *  查找下一个元素O(n)
 *  二分查找下一个元素的下标 O(logn)
 *  总的复杂度O(n + logn)
 *
 */
public class Solution {

    public static int GetNumberOfK(int [] array , int k) {
        // 查找数字k在数组中第一次出现的位置
        int first = binarySearch(array, k);
        int result = findThanK(array, k);
        // next - 1为数字k在数组中出现的最后一次位置
        int next = binarySearch(array, result);
        if(first == -1){
            return 0;
        }
        if(next == -1){
            return array.length - first;
        }
        return next - first;
    }

    private static int findThanK(int[] array, int k){
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > k && array[i] < result){
                result = array[i];
            }
        }
        return result;
    }

    // 查找第一个等于指定数的数的下标
    public static int binarySearch(int[] array, int k){
        int l = 0, h = array.length - 1;
        while (l <= h){
            int mid = l + ((h - l) >> 1);
            if(array[mid] > k){
                h = mid - 1;
            }else if(array[mid] < k){
                l = mid + 1;
            }else {
                if(mid == 0 || array[mid - 1] != k){
                    return mid;
                }else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}