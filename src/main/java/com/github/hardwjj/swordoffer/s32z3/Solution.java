package com.github.hardwjj.swordoffer.s32z3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 题： 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 *  解题思路：
 *     使用队列来进行层次遍历。
 *     不需要使用两个队列分别存储当前层的节点和下一层的节点，
 *     因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，
 *     只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        // 控制反转顺序
        boolean reverse = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> retList = new ArrayList<>();
            while (size-- > 0){
                TreeNode treeNode = queue.poll();
                if(treeNode == null){
                    continue;
                }
                retList.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
            // 使用jdk反转数组
            if(reverse){
                Collections.reverse(retList);
            }
            reverse = !reverse;
            // 如果集合不为空，所有子序列有元素，则直接添加到列表
            if(!retList.isEmpty()){
                ret.add(retList);
            }
        }
        return ret;
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
