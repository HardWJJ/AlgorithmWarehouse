package com.github.hardwjj.swordoffer.s34;

import java.util.ArrayList;

/**
 * 题： 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 *  解题思路：
 *     回溯法，深度优先搜索
 */
public class Solution {

    private ArrayList<ArrayList<Integer>> retList =  new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return retList;
        }
        backtracking(new ArrayList<>(), target, root);
        return retList;
    }

    private void backtracking(ArrayList<Integer> path, int target, TreeNode node){
        if(node == null){
            return;
        }

        target = target - node.val;
        path.add(node.val);
        // 判断是否到达了尾结点
        if(target == 0 && node.left == null && node.right == null){
            retList.add(new ArrayList<>(path));
        }else {
            backtracking(path, target, node.left);
            backtracking(path, target, node.right);
        }

        path.remove(path.size() - 1);
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
