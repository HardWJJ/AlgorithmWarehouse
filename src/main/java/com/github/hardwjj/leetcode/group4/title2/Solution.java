package com.github.hardwjj.leetcode.group4.title2;

/**
 * 题：二分查询：744. 大于给定元素的最小元素 （力扣）
 *
 * 题目描述
 *   给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
 *
 * Input:
 *   letters = ["c", "f", "j"]
 *   target = "d"
 *   Output: "f"
 *
 * Input:
 *   letters = ["c", "f", "j"]
 *   target = "k"
 *   Output: "c"
 *
 *
 *
 * 解题思路：
 *     二分搜索
 *     前提，待搜索的列表有序，由于字面循环，所以如果找不到更大的最小字符就返回第一个字符
 */
class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int n =  letters.length;
        int high = n - 1;
        int mid = -1;
        // 查找第一个大于给定值的下标
        while (low <= high) {
             mid = low + ((high - low) >> 1);
            if (letters[mid] > target) {
                if(mid == 0 || letters[mid - 1] <= target){
                    break;
                }else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return  low <= high? letters[mid] : letters[0];
    }

    public static void main(String[] args) {
        char c = nextGreatestLetter(new char[]{'c','f','j'}, 'c');
        System.out.println();
    }
}