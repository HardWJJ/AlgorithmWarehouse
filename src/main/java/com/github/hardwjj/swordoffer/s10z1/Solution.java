package com.github.hardwjj.swordoffer.s10z1;

public class Solution {
    public static int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }

        int pre1 = 0, pre2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
}