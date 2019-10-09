package com.github.hardwjj.swordoffer.s68;


/**
 * 题：树中两个节点的最低公共祖先（二叉查找树）
 *
 * 二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
 *
 * 解题思路：
 *  递归求解，根据左右节点的比较值方向进行搜索
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        // 左右节点都小于，往左走
        if(root.val > p.val  && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        }

        // 左右节点都大于，往右走
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