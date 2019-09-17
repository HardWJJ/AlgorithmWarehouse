package com.github.hardwjj.swordoffer.s55z2;

/**
 * 题：平衡二叉树
 *
 * 平衡二叉树左右子树高度差不超过 1。
 *
 * 解题思路：
 *   递归，递归考察每一个节点左右子树中的高度，有点深度搜索的意思,先左再右
 */
public class Solution {

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root){
        if(root == null || !isBalanced){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }

        // 返回左右子树中最高的子树再加上当前节点返回
        return 1 + Math.max(left, right);
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