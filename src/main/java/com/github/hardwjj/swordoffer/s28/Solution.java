package com.github.hardwjj.swordoffer.s28;

/**
 * 题： 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 *  解题思路：
 *      从树的左右节点开始递归考察
 */
public class Solution {

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode p1, TreeNode p2) {
        if(p1 == null && p2 == null){
            return  true;
        }

        if(p1 == null || p2 == null){
            return false;
        }

        if(p1.val != p2.val){
            return false;
        }

        return isSymmetrical(p1.left, p2.right) && isSymmetrical(p1.right, p2.left);
    }

}
