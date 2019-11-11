package com.github.hardwjj.leetcode.group3.title11;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：贪心算法：763. 分隔字符串使同种字符出现在一起（力扣）
 *
 * 题目描述
 *   字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  输入: S = "ababcbacadefegdehijhklij"
 *  输出: [9,7,8]
 *  解释:
 *   划分结果为 "ababcbaca", "defegde", "hijhklij"。
 *
 * 解题思路：
 *     贪心选择
 *     划分字符串，需要使划分的范围尽可能的小，但又必须符合条件使同种字符在一个区间出现
 */
class Solution {

    public List<Integer> partitionLabels(String S) {
        // 记录每个字母最后出现的在字串符S的下标  0  表示 a 最后出现的下标
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfChar[char2Index(S.charAt(i))] = i;
        }
        List<Integer> parLenList = new ArrayList<>();
        int firstIndex = 0;
        // 从头开始遍历
        while (firstIndex < S.length()){
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                // 获取当前字符在字符串中的最后位置
                int index = lastIndexOfChar[char2Index(S.charAt(i))];
                // 在给定的lastIndex范围内出现了在lastIndex之后的字符，需要更新lastIndex
                if(index > lastIndex){
                    lastIndex = index;
                }
            }

            parLenList.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return parLenList;
    }

    /**
     * 将字母转为对应数字 a 0  b 1
     */
    private int char2Index(char c){
        return c - 'a';
    }
}