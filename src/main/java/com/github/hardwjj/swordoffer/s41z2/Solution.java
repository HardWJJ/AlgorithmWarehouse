package com.github.hardwjj.swordoffer.s41z2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题： 字符流中第一个不重复的字符
 *  请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *  例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 *  当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 *
 *  解题思路：
 *     使用队列存储插入元素(先进先出),使用256长度数组每个下标统计对应ascii元素出现的个数
 *
 */
public class Solution {

    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        // 记录
        cnts[ch]++;
        queue.add(ch);
        // 根据插入顺序去除个数大于1个元素
        while (!queue.isEmpty() && cnts[queue.peek()] > 1){
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' :queue.peek();
    }
}