package com.github.hardwjj.swordoffer.s7;


import java.util.HashMap;

public class Solution {

    HashMap<Integer, Integer> indexOrder = new HashMap();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < in.length; i++) {
            indexOrder.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL){
        if(preL > preR){
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexOrder.get(root.val);
        int leftSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftSize + 1, preR, inIndex + 1);
        return root;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}