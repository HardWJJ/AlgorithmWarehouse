package com.github.hardwjj.swordoffer.s66;

/**
 * 题：构建乘积数组
 *
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 *
 * 解题思路：
 *  先求出每个数的从左往右乘积，再求出每个数的从右往左乘积，
 *  如B[5],先取出A[0] * A[1] * A[2] * A[3] * A[4];再求出 A[6] * A[7] * A[8] .......;
 */
public class Solution {

    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A == null || A.length == 0){
            return B;
        }

        // 左乘
        for (int i = 0, product = 1; i < B.length; product = product * A[i], i++) {
            B[i] = product;
        }

        // 右乘
        for (int i = B.length - 1, product = 1; i >= 0; product = product * A[i], i--) {
            B[i] = B[i] * product;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        multiply(a);
    }

}