package com.github.hardwjj.leetcode.group7.title9;

/**
 * 题：搜索：257. 二叉树的所有路径 DFS（力扣）
 *
 * 题目描述
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *     1
 *   /   \
 *  2     3
 *   \
 *    5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) {
            return paths;
        }
        // 记录节点的临时列表
        List<Integer> temp = new ArrayList<>();
        backtracking(root, temp, paths);
        return paths;
    }

    private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        if(node == null) {
            return;
        }
        values.add(node.val);
        // 判断是否是叶子节点
        if(isLeaf(node)) {
            buildPath(values, paths);
        }else {
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                return true;
            }
        }
        return false;
    }

    private void buildPath(List<Integer> values, List<String> paths) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if(i != values.size() - 1) {
                sb.append("->");
            }
        }
        paths.add(sb.toString());
    }
}

class TreeNode {
    int val;TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
