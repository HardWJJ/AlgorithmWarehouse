package com.github.hardwjj.swordoffer.s41z1;

import java.util.PriorityQueue;

/**
 * 题： 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 *  解题思路：
 *     使用大堆处理，大顶堆存储左边元素，使用小堆处理右边元素
 *
 */
public class Solution {

    /**
     * 存储左边元素大顶堆
     */
    private PriorityQueue<Integer> left = new PriorityQueue<>((v1 , v2) -> v2 - v1);

    /**
     * 存储右边元素的小顶堆
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    /**
     * 当前数据个数
     */
    private int n = 0;

    public void Insert(Integer num) {
        // 插入元素后需要保持平衡
        if(n % 2 == 0){
            // n为偶数，先添加到左堆，然后选取左堆最大值放到右堆
            left.add(num);
            right.add(left.poll());
        }else {
            // n不为偶数，则将元素放入小顶堆再将小顶堆堆顶元素取出，放到大顶堆中
            right.add(num);
            left.add(right.poll());
        }
        n++;
    }

    public Double GetMedian() {
        if(n % 2 == 0){
            return (left.peek() +  right.peek()) / 2.0;
        }else {
            return (double)right.peek();
        }
    }


}