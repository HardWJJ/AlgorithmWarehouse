package com.github.hardwjj.swordoffer.s68;

/**
 * @author wjiajun
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);

        return left == null? right : right == null ? left : root;
    }
}
