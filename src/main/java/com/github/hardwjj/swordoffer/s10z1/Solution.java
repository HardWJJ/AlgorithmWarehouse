package com.github.hardwjj.swordoffer.s10z1;

/**
 * 题： 斐波那契数列
 * 求斐波那契数列的第 n 项，n <= 39。
 *
 *
 * 解：
 * 如果使用递归求解，会重复计算一些子问题。例如，计算 f(4) 需要计算 f(3) 和 f(2)，计算 f(3) 需要计算 f(2) 和 f(1)，可以看到 f(2) 被重复计算了。
 * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 * 动态规划的无后效性：当前节点的状态只需要由上一个状态推导出，不需要考虑上上个状态
 *
 */
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