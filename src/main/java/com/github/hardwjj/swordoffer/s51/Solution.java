package com.github.hardwjj.swordoffer.s51;

/**
 * 题： 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 *  解题思路：
 *     使用归并排序，在将临时数组拷贝回原数组的过程中就可以对逆序对进行统计
 */
public class Solution {

    private long cnt = 0;
    // 归并函数需要的临时数组
    private int[] temp;

    public int InversePairs(int [] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int left, int right){
        if(right - left < 1){
            return;
        }

        int mid  = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        int i = left, j = mid + 1, k = left;
        while (i <= mid || j <= right){
            if(i > mid){
                // 左边数组已经遍历结束
                temp[k] = nums[j++];
            }else if(j > right){
                // 右边数组已经遍历结束
                temp[k] = nums[i++];
            }else if(nums[i] <= nums[j]){
                // 左边小于右边
                temp[k] = nums[i++];
            }else {
                // 左边大于右边，计算右边放入临时数组前的逆序对数，nums[i...mid] 都大于 nums[j]
                temp[k] = nums[j++];
                this.cnt = this.cnt + (mid - i + 1);
            }
            k++;
        }
        for (k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
    }
}