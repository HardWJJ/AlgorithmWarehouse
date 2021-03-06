package com.github.hardwjj.swordoffer.s39;

/**
 * 题： 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *  解题思路：
 *       多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(n)。
 *
 *       使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。
 *       如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
 *       此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
 *
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int majority = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] == majority){
                cnt++;
            }else {
                cnt--;
            }
            // 重新在剩余的元素中找超过一半的数字
            if(cnt == 0){
                cnt = 1;
                majority = array[i];
            }
        }

        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == majority){
                cnt ++;
            }
        }

        if(cnt > array.length / 2){
            return majority;
        }else {
            return 0;
        }
    }
}