package com.github.hardwjj.swordoffer.s58z1;

/**
 * 题：翻转单词顺序列
 *
 * Input:
 * "I am a student."
 *
 *  Output:
 * "student. a am I"
 *
 *
 * 解题思路：
 *  先选旋转每个单词，然后旋转整个字符数组
 *  除了存储字符串用到的字符数组，在计算过程中不用到其他数据，空间复杂度为O(1)
 */
public class Solution {
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        for (; j <= n; j++) {
            // 反转单词
            if(j == n || chars[j] == ' '){
                resevse(chars, i, j - 1);
                i = j + 1;
            }
        }
        // 反转整个字串符数组
        resevse(chars, 0, n);
        return new String(chars);
    }

    private void resevse(char[] c, int i, int j){
        while (i < j){
            swap(c, i++, j--);
        }
    }

    private void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}