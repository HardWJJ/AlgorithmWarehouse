package com.github.hardwjj.swordoffer.s66;

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