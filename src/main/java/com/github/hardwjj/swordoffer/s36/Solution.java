package com.github.hardwjj.swordoffer.s36;

/**
 * 题： 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *  解题思路：
 *    中序遍历二叉搜索树，每次递归维护好前一个节点
 *
 */
public class Solution {

    private TreeNode head;

    private TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        // 左
        inOrder(node.left);

        // 中
        node.left = pre;
        // 前一个节点不为空进行双向链接
        if(pre != null){
            pre.right = node;
        }

        // 更新前一个节点
        pre = node;

        if(head == null){
            head = node;
        }

        // 右
        inOrder(node.right);
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
