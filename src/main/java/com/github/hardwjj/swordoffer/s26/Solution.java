package com.github.hardwjj.swordoffer.s26;


/**
 * 题： 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 *
 *  解题思路：
 *      分别考察树根节点，根节点的左子树，根节点的右子树
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || isSubtreeWithRoot(root1.left, root2) || isSubtreeWithRoot(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2){
        // 如果待考察的左子树已经考察完毕
        if(root2 == null){
            return true;
        }
        // 如果左子树未考察完但主树已经考察完
        if(root1 == null) {
            return false;
        }
        // 如果对应节点不相等
        if(root1.val != root2.val){
            return false;
        }
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
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