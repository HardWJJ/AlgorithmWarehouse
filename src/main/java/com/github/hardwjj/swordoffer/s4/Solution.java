package com.github.hardwjj.swordoffer.s4;

public class Solution {

    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        int r = 0, c = array[0].length - 1;
        while (r <= array.length - 1 && c >= 0){
            if(target < array[r][c]){
                c--;
            }else if(target > array[r][c]){
                r++;
            }else {
               return true;
            }
        }
        return false;
    }

}