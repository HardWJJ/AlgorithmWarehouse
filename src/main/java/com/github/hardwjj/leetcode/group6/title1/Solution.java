package com.github.hardwjj.leetcode.group6.title1;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题：搜索：1091. 二进制矩阵中的最短路径 （力扣）
 *
 * 题目描述
 *   0 表示可以经过某个位置，求解从左上角到右下角的最短路径长度。
 *
 * 示例 1：
 *  输入：[[0,1],[1,0]]
 *  输出：2
 *
 * 示例 2：
 *  输入：[[0,0,0],[1,1,0],[1,1,0]]
 *  输出：4
 *
 * 解题思路：
 *      广度优先搜索获取最短路径,最先到达右下角的为唯一或其中一条最短路径，实现方式可以使用先进先出队列
 */
class Solution {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        // 定义8个方向
        int[][] dirctions = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length, n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // 初始化起点数据
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            pathLength++;
            // 队列中为相同长度路径的几种选择节点，对应于广度优先搜索树中的同一级的节点
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> temp = queue.poll();
                Integer key = temp.getKey();
                Integer value = temp.getValue();
                // 标记为已走
                grid[key][value] = 1;
                // 遍历相同层级节点的所有可能解
                for (int[]  dirction: dirctions) {
                    int nextKey = key + dirction[0];
                    int nextValue = value + dirction[1];
                    // 判断边界问题，或者是否已经走过
                    if(nextKey < 0 || nextValue < 0 || nextKey >= m || nextValue >= n || grid[nextKey][nextValue] == 1) {
                        continue;
                    }
                    // 找到最短路径
                    if(nextKey == m - 1 && nextValue == n - 1) {
                        return pathLength + 1;
                    }
                    // 广度优先遍历，记录已经走的方向
                    queue.add(new Pair<>(nextKey, nextValue));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1, 0, 0},{1, 1, 0},{1, 1, 0}}));
    }
}