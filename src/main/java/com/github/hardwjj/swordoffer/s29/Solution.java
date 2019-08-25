package com.github.hardwjj.swordoffer.s29;

import java.util.ArrayList;

/**
 * 题： 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *  解题思路：
 *     环形添加，逐渐缩小范围
 */
public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
           return new ArrayList<>();
       }
       ArrayList<Integer> list = new ArrayList<>();
       int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
       // 判断边界
       while (r1 <= r2 && c1 <= c2){

           for (int i = c1; i <= c2; i++) {
               list.add(matrix[r1][i]);
           }

           for (int i = r1 + 1; i <= r2; i++) {
               list.add(matrix[i][c2]);
           }

           // 判断是否仅剩下一行
           if(r1 != r2){
               for (int i = c2 - 1; i >= c1; i--) {
                    list.add(matrix[r2][i]);
               }
           }

           // 判断是否仅剩下一列
           if(c1 != c2){
               for (int i = r2 - 1; i >= r1 + 1; i--) {
                    list.add(matrix[i][r1]);
               }
           }
           r1++; c1++; r2--; c2--;
       }
       return list;
    }
}