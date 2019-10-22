package com.github.hardwjj.leetcode.group2.title3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题：排序：桶排序   2. 按照字符出现次数对字符串排序
 *     451. Sort Characters By Frequency (Medium)
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 *
 * 解题思路：
 *     以字符串长度创建桶长度，以避免所有字符的出现次数都是一次，然后从后往前遍历，取出一组可能的解
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> statisticMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            statisticMap.put(aChar, statisticMap.getOrDefault(aChar, 0) + 1);
        }

        // 默认创建字符串长度的桶大小，避免所有字符都出现一次的情况
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Character c : statisticMap.keySet()){
            int index = statisticMap.get(c);
            if(bucket[index] == null){
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(c);
        }

        // 拼装str
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] == null){
                continue;
            }

            for (char c : bucket[i]) {
                // 添加对应出现次数的字符
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }

            }
        }
        return sb.toString();
    }
}