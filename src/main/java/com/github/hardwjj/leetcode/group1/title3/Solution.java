package com.github.hardwjj.leetcode.group1.title3;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题：双指针：   3. 反转字符串中的元音字符
 *     345. Reverse Vowels of a String (Easy)
 *
 * Given s = "leetcode", return "leotcede".
 *
 *
 * 解题思路：
 *   使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
 */
class Solution {

    private final HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = new char[s.length()];
        while (i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                // 按照原来复制
                chars[i++] = ci;
            }else if(!vowels.contains(cj)){
                // 按照原来复制
                chars[j--] = cj;
            }else {
                // 元音字母反转
                chars[i++] = cj;
                chars[j--] = ci;
            }
        }
        return chars.toString();
    }
}
