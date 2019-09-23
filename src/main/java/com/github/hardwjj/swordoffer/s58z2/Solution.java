package com.github.hardwjj.swordoffer.s58z2;


/**
 * 题：左旋转字符串
 *
 * Input:
 *     S="abcXYZdef"
 *      K=3
 *
 * Output:
 *     "XYZdefabc"
 *
 * 解题思路：
 *  先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(n >= str.length()){
            return str;
        }

        char[] chars = str.toCharArray();
        //  先将前半部分翻转
        reserse(chars, 0, n - 1);
        //  再将后半部分翻转
        reserse(chars, n, chars.length - 1);
        //   最后将整个字符串翻转
        reserse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reserse(char[] chars, int i, int j){
        while (i < j){
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}