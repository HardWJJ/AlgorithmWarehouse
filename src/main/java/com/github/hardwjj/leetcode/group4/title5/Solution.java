package com.github.hardwjj.leetcode.group4.title5;

/**
 * 题：二分查询：153. 寻找旋转排序数组中的最小值 （力扣）
 *
 * 题目描述
 *   假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 *  请找出其中最小的元素,假设数组中不存在重复元素。
 *
 *  示例 1:
 *  输入: [3,4,5,1,2]
 *  输出: 1
 *
 *  示例 2:
 *  输入: [4,5,6,7,0,1,2]
 *  输出: 0
 *
 * 解题思路：
 *     二分搜索
 *     取出中间元素，与搜索区间最大下标节点high进行比较，如果mid元素大于high元素，则说明high位于旋转数组末尾，mid位于选择数组中间，求最小值时将low位置设置为middle + 1
 *     如果mid元素小于等于high元素，则说明当前搜索区间在选择数组的右边，此时应该缩小high范围
 */
class Solution {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        //  由于 h = m;避免死循环，不写成low <= high
        while (low < high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}