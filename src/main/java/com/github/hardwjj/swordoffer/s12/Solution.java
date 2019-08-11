package com.github.hardwjj.swordoffer.s12;

/**
 * 题： 矩阵中的路径
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始
 * 每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *
 *
 * 解：
 * 使用回溯法（backtracking）进行求解，它是一种暴力搜索方法，通过搜索所有可能的结果来求解问题。
 * 回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。
 */
public class Solution {

    private final static int[][] next = {{0, -1},{1, 0},{0, 1},{-1, 0}};

    private int rows;

    private int cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(rows == 0 || cols == 0){
            return false;
        }

        this.rows = rows;
        this.cols = cols;

        boolean[][] marked = new boolean[rows][cols];
        // 需要先将数组转换成矩阵
        char[][] matirx = buildMatrix(matrix);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 尝试每一个起点
                if(backtracking(matirx,  str, marked, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathlen, int r, int c){
        // 待查找的字符串已找到
        if(pathlen == str.length){
            return true;
        }

        // 条件不符，或已被搜索过
        if(r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathlen] || marked[r][c]){
            return false;
        }

        marked[r][c] = true;
        for (int[] ne : next) {
            // 递归深度优先寻找下一个节点
            if(backtracking(matrix, str, marked, pathlen + 1, r + ne[0], c + ne[1])){
                return true;
            }
        }
        // 回溯，状态恢复
        marked[r][c] = false;
        return  false;
    }

    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }
}