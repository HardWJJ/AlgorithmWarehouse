package com.github.hardwjj.swordoffer.s68;

/**
 * 题：树中两个节点的最低公共祖先（普通二叉树）
 *
 * 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
 *
 * 解题思路：
 *  递归左右节点，求出最低公共节点
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root节点等于左右的一个节点，返回root节点
        if(root == null || p == root || q == root){
            return root;
        }
        // 递归左右节点
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);

        return left == null? right : right == null ? left : root;
    }
}
