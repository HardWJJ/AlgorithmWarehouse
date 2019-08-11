package com.github.hardwjj.swordoffer.s7;


import java.util.HashMap;

/**
 * 题：重建二叉树
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 *
 *
 * 解：
 * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
 *
 */
public class Solution {

    HashMap<Integer, Integer> indexOrder = new HashMap();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        // O(n)时间遍历中序数组，得到O(1)存取的map
        for (int i = 0; i < in.length; i++) {
            indexOrder.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }


    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL){
        // 前序遍历待处理区间为空
        if(preL > preR){
            return null;
        }

        // 取前序遍历最左节点即中序遍历中间节点
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexOrder.get(root.val);
        // 左子树中序遍历、前序遍历范围
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