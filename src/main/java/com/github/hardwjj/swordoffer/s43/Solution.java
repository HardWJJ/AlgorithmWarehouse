package com.github.hardwjj.swordoffer.s43;

/**
 * 题： 从 1 到 n 整数中 1 出现的次数
 *
 *  解题思路：获取个位数上的1然后获取十位数上的1然后获取百位数上的1逐层获取
 */
public class Solution {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            // 相当于： 由于前面位数的变化累计的1 + 余数的1
            // +8 如果当前要求位数已经从2开始，则不按余数来统计，要求位数从1开始才统计余数
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution(122);
    }
}




