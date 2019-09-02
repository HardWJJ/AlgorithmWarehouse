package com.github.hardwjj.swordoffer.s40;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 题： 最小的 K 个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 *  解题思路：
 *     快速选择
 *          复杂度：O(N) + O(1)
 *          只有当允许修改数组元素时才可以使用
 *          快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，
 *          且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
 *          可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
 *
 *     大小为 K 的最小堆
 *          复杂度：O(NlogK) + O(K)
 *          特别适合处理海量数据
 *          应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
 *          维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
 *
 */
public class Solution {

    /**
     * 快速选择
     * 复杂度：O(N) + O(1)
     * 进行大约一次快排中的选分隔partition操作约等于O(1)，遍历数组构造返回值O(N)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(k > nums.length || k <= 0){
            return ret;
        }
        // 借助快排思想找出前K个元素
        findKthSmallest(nums, k - 1);

        for (int i = 0; i < k; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    private void findKthSmallest(int[] nums, int k){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int j = partition(nums, l, h);
            if(j == k){
                return;
            }else if(j > k){
                h = j - 1;
            }else {
                l = j + 1;
            }
        }
    }

    /**
     * 默认选择第一个为切割点，函数返回下标j,下标j对应的元素比前面所有0 - j-1大， 比 j + 1 - h 小
     */
    private int partition(int[] nums, int l, int h){
        int p = nums[l];
        int i = l, j = h + 1;
        while (true){
            while (i != h && nums[++i] < p){}
            while (j != l && nums[--j] > p){}
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 大小为 K 的最小堆
     * 时间复杂度：O(NlogK) + O(K)
     * N个堆化操作，每个堆化操作复杂度O(logK)，最后遍历堆中元素，构造返回值O(k)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] nums, int k) {
        if(k > nums.length || k < 0){
            return new ArrayList<>();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}