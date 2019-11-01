package com.github.hardwjj.leetcode.group3.title3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题：贪心算法：452. 用最少数量的箭引爆气球 力扣
 *
 * 题目描述
 *    Input:
 *    [[10,16], [2,8], [1,6], [7,12]]
 *
 *    Output:
 *     2
 *  气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 *
 * 解题思路：
 *     贪心选择
 *     计算不重叠的区间个数,对于区间[1, 2] 和 [2, 3] 属于重叠区间
 *     将第一个区间作为起始区间，最大程度的选取重叠区间，以保证更多重叠区间合并掉
 */
class Solution {
    // 返回的不重复区间个数就是需要的箭头数
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        // 先按照区间的结束位置按从小到大进行排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 出现重叠
            if(points[i][0] <= end){
                continue;
            }
            // 区间无法重叠，不重复区间数 + 1
            cnt++;
            // 更新最近一次出现的不重复区间
            end = points[i][1];
        }
        return cnt;
    }
}