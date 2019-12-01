package com.github.hardwjj.leetcode.group5.title2;

import java.util.LinkedList;
import java.util.List;

/**
 * 题：分支：95. 不同的二叉搜索树 （力扣）
 *
 * 题目描述
 *   给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
 *
 * 示例 :
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *   1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 * 2     1         2                 3
 *
 *
 * 解题思路：
 *      分治，先进行划分，对划分好的区间使用相同的求解方法，分治不同于动态规划，使用分治法划分的区间，区间和区间之间是没有关联的
 */
class Solution {

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        for (TreeNode treeNode : list) {
            System.out.println();
            System.out.println(treeNode);
        }
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}