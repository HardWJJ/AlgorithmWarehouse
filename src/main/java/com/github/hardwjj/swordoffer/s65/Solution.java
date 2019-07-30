package com.github.hardwjj.swordoffer.s65;

public class Solution {


    public static int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Add(7, 5);
    }

}
