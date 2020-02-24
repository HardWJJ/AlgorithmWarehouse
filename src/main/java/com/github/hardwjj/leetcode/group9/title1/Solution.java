package com.github.hardwjj.leetcode.group9.title1;

/**
 * 题：数学：204. 计数质数 DFS（力扣）
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
class Solution {

    public int countPrimes(int n) {
        boolean[] noPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            // 不是素数排除
            if(noPrimes[i]) {
                continue;
            }
            count++;
            // 排除掉能被素数整除的数
            for (long j = ((long)i) * i; j < n; j+= i) {
                noPrimes[(int)j] = true;
            }
        }
        return count;
    }

}