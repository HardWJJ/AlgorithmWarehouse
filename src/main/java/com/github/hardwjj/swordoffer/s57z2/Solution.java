package com.github.hardwjj.swordoffer.s57z2;

import java.util.ArrayList;

/**
 * 题：和为 S 的连续正数序列
 *
 * 输出所有和为 S 的连续正数序列。
 * 例：和为 100 的连续序列
 *    [9, 10, 11, 12, 13, 14, 15, 16]
 *    [18, 19, 20, 21, 22]。
 *
 * 解题思路：类似滑动窗口
 *   使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 *      - 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 *      - 如果 sum > target，移动较大的元素，使 sum 变小一些；
 *      - 如果 sum < target，移动较小的元素，使 sum 变大一些。
 */
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        // 连续的和从3开始
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum){
            if(curSum > sum){
                curSum -= start;
                start++;
            }else if(curSum < sum){
                end++;
                curSum += end;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                // 更新区间
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}