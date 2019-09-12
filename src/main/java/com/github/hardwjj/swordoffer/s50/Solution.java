package com.github.hardwjj.swordoffer.s50;

import java.util.BitSet;

/**
 * 题： 第一个只出现一次的字符位置
 *
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 *  Input: abacc
 *  Output: b
 *
 *  解题思路：
 *      为了降低空间复杂度，使用两个bit来存储,
 *      0 0 一次都没出现
 *      0 1 出现一次
 *      1 1 出现一次以上
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!bs1.get(c) && !bs2.get(c)){
                // 0 0 -> 0 1
                bs1.set(c);
            }else if(bs1.get(c) && !bs2.get(c)){
                // 0 1 -> 1 1
                bs2.set(c);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(bs1.get(c) && !bs2.get(c)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(2);
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(1));
    }
}
