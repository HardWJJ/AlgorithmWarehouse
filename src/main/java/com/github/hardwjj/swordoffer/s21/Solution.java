package com.github.hardwjj.swordoffer.s21;

/**
 * 题： 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 *
 * 解题思路：
 * 方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
 * 方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
 */
public class Solution {

    public void reOrderArray(int [] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int N = nums.length;

        // 使用冒泡将偶数冒到尾巴
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(isEven(nums[j]) && !isEven(nums[j + 1])){
                    swap(nums, j, j + 1);
                }
            }
        }

    }

    private boolean isEven(int x){
        return x % 2 == 0;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}