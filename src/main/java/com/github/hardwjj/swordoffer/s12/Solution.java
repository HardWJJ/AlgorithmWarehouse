package com.github.hardwjj.swordoffer.s12;

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
        char[][] matirx = buildMatrix(matrix);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(backtracking(matirx,  str, marked, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathlen, int r, int c){
        if(pathlen == str.length){
            return true;
        }

        if(r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathlen] || marked[r][c]){
            return false;
        }

        marked[r][c] = true;
        for (int[] ne : next) {
            if(backtracking(matrix, str, marked, pathlen + 1, r + ne[0], c + ne[1])){
                return true;
            }
        }
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