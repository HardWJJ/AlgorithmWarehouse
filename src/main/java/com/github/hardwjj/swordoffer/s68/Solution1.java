package com.github.hardwjj.swordoffer.s68;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val > p.val  && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val){
            lowestCommonAncestor(root.right, p ,q);
        }

        return root;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}