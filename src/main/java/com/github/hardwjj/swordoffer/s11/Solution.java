package com.github.hardwjj.swordoffer.s11;

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int l = 0, h = array.length - 1;
        while (l < h){
            int mid = l + ((h - l) >> 1);
            if(array[h] == array[mid]){

            }else if(array[h] < array[mid]){
                l = mid + 1;
            }else {
                h = mid;
            }
        }
        return array[l];
    }

    private int minNumbers(int[] array, int l, int h){
        for (int i = l; i <= h; i++) {
            if(array[i] > array[i + 1]){
                return array[i + 1];
            }
        }
        return array[l];
    }
}