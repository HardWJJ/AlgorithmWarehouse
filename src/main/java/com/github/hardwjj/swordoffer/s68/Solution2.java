package com.github.hardwjj.swordoffer.s68;

/**
 * 题：树中两个节点的最低公共祖先（二叉查找树）
 *
 * 二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
 *
 * 解题思路：
 *  递归求解，根据左右节点的比较值方向进行搜索
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root节点等于左右的一个节点，返回root节点
        if(root == null || p == root || q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);

        return left == null? right : right == null ? left : root;
    }
}
