package com.github.hardwjj.swordoffer.s38;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题： 字符串的排列
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 *
 *  解题思路：
 *       深度优先搜索+回溯法
 *
 */
public class Solution {

    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0){
            return ret;
        }
        char[] chars = str.toCharArray();
        boolean[] isSelect = new boolean[chars.length];
        Arrays.sort(chars);
        backtracking(chars, isSelect, new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] isSelect, StringBuilder curStr){
        // 获取其中一个解
        if(curStr.length() == chars.length){
            ret.add(curStr.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 防止同一个元素重复选择
            if(isSelect[i]){
                continue;
            }

            // 防止相同元素产生两组相同解
            if(i != 0 && chars[i] == chars[i - 1] && !isSelect[i - 1]){
                continue;
            }

            curStr.append(chars[i]);
            isSelect[i] = true;
            backtracking(chars, isSelect, curStr);
            isSelect[i] = false;
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }

}