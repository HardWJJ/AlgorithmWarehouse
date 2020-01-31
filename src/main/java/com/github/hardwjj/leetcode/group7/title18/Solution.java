package com.github.hardwjj.leetcode.group7.title18;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：131. 分割回文串 DFS（力扣）
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 *
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        doPartition(s, temp, result);
        return result;
    }

    private void doPartition(String s, List<String> temp, List<List<String>> result) {
        if(s.length() == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                temp.add(s.substring(0, i + 1));
                doPartition(s.substring(i + 1), temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if(s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}