package com.github.hardwjj.leetcode.group7.title7;

import java.util.ArrayList;
import java.util.List;

/**
 * 题：搜索：93. 复原IP地址 DFS（力扣）
 *
 * 题目描述
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 *  dfs，深度优先搜索时加上回溯
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        deRestore(tempAddress, 0, addresses, s);
        return addresses;
    }

    private void deRestore(StringBuilder tempAddr, int k, List<String> address, String s) {
        if(k == 4 || s.length() == 0) {
            if(k == 4 && s.length() == 0) {
                address.add(tempAddr.toString());
            }
            return;
        }

        // 最多选择三个数
        for (int i = 0; i < s.length() && i <= 2; i++) {
            // 如果目前选择大于一个数，但是首个数为0则跳过
            if(i != 0 && s.charAt(0) == '0') {
                return;
            }
            String num = s.substring(0, i + 1);
            // 不符合
            if(255 < Integer.valueOf(num)) {
                return;
            }
            // 已经不是地址的第一个
            if(tempAddr.length() != 0) {
                num = "." + num;
            }
            tempAddr.append(num);
            deRestore(tempAddr, k + 1, address, s.substring(i + 1));
            tempAddr.delete(tempAddr.length() - num.length(), tempAddr.length());
        }
    }

}