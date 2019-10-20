package com.github.hardwjj.leetcode.group2.title1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 题：排序：   1. Kth Element
 *     215. Kth Largest Element in an Array (Medium)
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * 找到倒数第 k 个的元素。
 *
 * 解题思路：
 *   排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
 *   堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
 *   快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
 */
class Solution {

    // 1 Quicksort 原地排序
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 2 堆， 需要维护k的大的堆
    public int findKthLargest2(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    // 3 利用快排需要基准元素，原地排序, 时间复杂度 O(N + N / 2 + N / 4 + N / 8 + ..... + 1) ≈ O(N)
    public int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h){
            int j = partition(nums, l, h);
            if(j == k){
                break;
            }else if(j < k){
                l = j + 1;
            }else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h){
        int i = l, j  = h + 1;
        while (true){
            while (a[++i] < a[l] && i < h){}
            while (a[--j] > a[l] && j > l){}
            if(i >= j){
                break;
            }
            swap(a, i, j);
        }
        // 此时j 小于等于基准元素a[l]
        swap(a, j, l);
        return j;
    }

    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}