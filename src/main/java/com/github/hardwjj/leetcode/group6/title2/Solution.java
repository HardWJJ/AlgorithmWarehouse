package com.github.hardwjj.leetcode.group6.title2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题：搜索：279. 组成整数的最小平方数数量 （力扣）
 *
 * 题目描述
 *   给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *  输入: n = 12
 *  输出: 3
 *  解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *  输入: n = 13
 *  输出: 2
 *  解释: 13 = 4 + 9.
 *
 * 解题思路：
 *      广度优先搜索获取最短路径
 *      类似n叉树，将每个整数看成图中的一个节点，如果两个数之前差一个平方数，则就存在一条边，求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 *
 */
class Solution {

    public static int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (Integer square : squares) {
                    int next = cur - square;
                    // 不符合，提前退出
                    if(next < 0) {
                        break;
                    }
                    // 刚好符合，返回
                    if(next == 0) {
                        return level;
                    }
                    // 如果已被选择则放弃
                    if(marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    // 存放下一级遍历的节点
                    queue.add(next);
                }
            }
        }
        return level;
    }

    /**
     * 1,4,9,...
     */
    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}