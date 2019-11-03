package com.github.hardwjj.leetcode.group3.title4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题：贪心算法：406. 根据身高和序号重组队列
 *
 * 题目描述
 *    Input:
 *    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 *    Output:
 *    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 *
 * 解题思路：
 *     贪心选择
 *     为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
        // 身高h降序排序，如果身高相同按k升序
        Arrays.sort(people, (a, b) -> (a[0] == b[0]? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}