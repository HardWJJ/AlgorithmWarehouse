package com.github.hardwjj.leetcode.group1.title7;

import java.util.List;

/**
 * 题：双指针：   7. 最长子序列
 *     524. Longest Word in Dictionary through Deleting (Medium)
 *
 * Input:
 *    s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 *    "apple"
 *
 * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 *
 * 解题思路：
 *   通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longWord = "";
        for (int i = 0; i < d.size(); i++) {
            int l1 = longWord.length(), l2 = d.get(i).length();
            // 当前字符串序列比之前选出的字符串序列长度小
            if(l1 > l2){
                continue;
            }
            // 相同长度的结果，但返回字典序比之前选出的字串符序列大
            if(l1 == l2 && longWord.compareTo(d.get(i)) < 0){
                continue;
            }
            if(isSubStr(s, d.get(i))){
                longWord = d.get(i);
            }
        }
        return longWord;
    }

    private boolean isSubStr(String s, String target){
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}