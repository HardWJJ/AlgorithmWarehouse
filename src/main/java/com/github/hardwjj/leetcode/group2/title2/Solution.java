package com.github.hardwjj.leetcode.group2.title2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题：排序：桶排序   1. 出现频率最多的 k 个元素
 *     347. Top K Frequent Elements (Medium)
 *
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * 解题思路：
 *   设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
 *   把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 统计每个数出现频率， key 数字 value 对应出现的次数
        Map<Integer, Integer> statisticMap  = new HashMap<>();
        for (int num : nums) {
            statisticMap.put(num, statisticMap.getOrDefault(num, 0) + 1);
        }

        // 最坏情况，每个数至少出现一次，且仅出现一次，则需要的最小长度 buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : statisticMap.keySet()) {
            int frequency = statisticMap.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        // 此时，频率最高的出现在buckets下标存在且最大的桶里

        // 存储需要返回的k个元素
        List<Integer> topK = new ArrayList<>();
        // 从buckets索引尾部开始往上遍历，结束条件为遍历结束，或者k个元素都已经找到
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if(buckets[i] == null){
                continue;
            }

            // 需要整个buckets[i]槽的数据
            if(buckets[i].size() <= (k - topK.size())){
                topK.addAll(buckets[i]);
            // 需要部分buckets[i]槽的数据
            }else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }
}