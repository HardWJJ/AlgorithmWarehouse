package com.github.hardwjj.swordoffer.s27;

/**
 * 题： 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *  解题思路：
 *      从树根开始从上到下递归交换左右子树
 */
public class Solution {

    // 输入一个树根节点，不断交换根节点的左右子树，使其成为镜像
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root){
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}
