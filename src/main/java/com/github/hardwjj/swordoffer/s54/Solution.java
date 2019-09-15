package com.github.hardwjj.swordoffer.s54;

/**
 * 题：二叉查找树的第 K 个结点
 *
 * 解题思路：
 *   中序遍历
 */
public class Solution {

    private TreeNode retNode;

    private int cnt = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return retNode;
    }

    private void inOrder(TreeNode root, int k){
        if(root == null || cnt >= k){
            return;
        }
        // 左
        inOrder(root.left, k);

        // 中
        cnt++;
        if(cnt == k){
            retNode = root;
            return;
        }

        // 右
        inOrder(root.right, k);
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
