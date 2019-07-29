package com.github.hardwjj.swordoffer.s53;

public class Solution {

    public static int GetNumberOfK(int [] array , int k) {
        int first = binarySearch(array, k);
        int next = binarySearch(array, k + 1);
        if(first == -1){
            return 0;
        }
        if(next == -1){
            return array.length - first;
        }
        return next - first;
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