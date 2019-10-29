package com.github.hardwjj.leetcode.group3.title1;

import java.util.Arrays;

/**
 * 题：贪心算法：455. 分发饼干
 *
 * 题目描述
 *
 * 每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 *
 *
 * 解题思路：
 *     贪心选择
 *     给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。因为最小的孩子最容易得到满足，所以先满足最小的孩子。
 *
 *     假设存在一种最优策略，给该孩子分配第 n 个饼干，并且 m < n。经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。
 *     因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 排序，保证从胃口最小的孩子开始满足
        Arrays.sort(g);
        // 排序，保证从饼干最小的开始尝试
        Arrays.sort(s);
        int gi = 0;
        // si 迭代下一个块饼干
        for (int si = 0; gi < g.length && si < s.length; si++) {
            // 尝试让尺寸最小的饼干满足胃口最小的孩子
            if(g[gi] <= s[si]){
                gi++;
            }
        }
        return gi;
    }
}