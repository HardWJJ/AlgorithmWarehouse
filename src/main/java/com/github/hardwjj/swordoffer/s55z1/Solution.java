package com.github.hardwjj.swordoffer.s55z1;


/**
 * 题：二叉树的深度
 *
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 解题思路：
 *   递归，递归考察每一个节点左右子树中的最大值，有点深度搜索的意思,先左再右
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}

class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
     }

 }
