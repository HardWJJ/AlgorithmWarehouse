package com.github.hardwjj.leetcode.group3.title2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题：贪心算法：435. 不重叠的区间个数 力扣
 *
 * 题目描述
 *     给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *     1. 可以认为区间的终点总是大于它的起点。
 *     2. 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 示例 1:
 *      输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *      输出: 1
 *      解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 示例 2:
 *      输入: [ [1,2], [1,2], [1,2] ]
 *      输出: 2
 *      解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 解题思路：
 *     贪心选择
 *     先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。最多能组成的不重叠区间个数使用贪心选择，
 *     在每次选择中，选择的区间结尾最小的这样留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *     按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        // 先按尾部进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 设置初始值
        int cnt = 1; // 已选择的区间
        int end = intervals[0][1]; // 默认
        for (int i = 1; i < intervals.length; i++) {
            // 后面区间头与已选择的区间重合
            if(intervals[i][0] < end){
                continue;
            }
            // 选择 i 区间后
            end = intervals[i][1];
            // 更新已选区间数量
            cnt++;
        }
        // 返回需要移除的区间数量
        return intervals.length - cnt;
    }
}