package com.github.hardwjj.swordoffer.s11;

/**
 * 题： 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 *
 * 解：
 * 将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。
 * 新的旋转数组的数组元素是原数组的一半，从而将问题规模减少了一半，这种折半性质的算法的时间复杂度为 O(logn)。
 *
 * 非递减数组的第一个元素一定小于等于最后一个元素。
 * 通过修改二分查找算法进行求解（l 代表 low，m 代表 mid，h 代表 high）：
 * 当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时令 h = m；
 * 否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int l = 0, h = array.length - 1;
        // 修改二分查找法
        while (l < h){
            // 此处注意运算符优先级
            int mid = l + ((h - l) >> 1);
            if(array[h] == array[mid]){
                // 无法知道数组再哪个区间
                minNumbers(array, l, h);
            }else if(array[h] < array[mid]){
                // 旋转数组的后半段
                l = mid + 1;
            }else {
                h = mid;
            }
        }
        return array[l];
    }

    private int minNumbers(int[] array, int l, int h){
        for (int i = l; i <= h; i++) {
            if(array[i] > array[i + 1]){
                return array[i + 1];
            }
        }
        return array[l];
    }
}