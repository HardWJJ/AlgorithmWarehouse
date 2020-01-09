package com.github.hardwjj.leetcode.group7.title6;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：17. 电话号码的字母组合 DFS（力扣）
 *
 * 题目描述
 *   给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *   给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *  dfs，深度优先搜索时加上回溯
 */
class Solution {

    private static final String[] KETS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder sb, List<String> combinations, final String digits) {
        if(sb.length() == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        // 遍历 digits 获取对应顺序上的所有数字
        int index = digits.charAt(sb.length()) - '0';
        char[] chars = KETS[index].toCharArray();
        // 回溯
        for (char aChar : chars) {
            sb.append(aChar);
            doCombination(sb, combinations, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}