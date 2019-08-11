package com.github.hardwjj.swordoffer.s8;

/**
 * 题：二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 *
 * 解：
 * 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
 * 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
 *
 */
public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null){
            // 右子树不为空
            TreeLinkNode rightNode = pNode.right;
            // 寻找右子树中最深左子树，没有则返回右子树
            while (rightNode.left != null){
                rightNode = rightNode.left;
            }
            return rightNode;
        }else {
            // 不存在右子树则往上寻找下一节点
            TreeLinkNode parentNode = pNode.next;
            // 如果该节点是父节点的右子树则继续往上寻找
            while (pNode != null && parentNode != null && parentNode.left != pNode){
                pNode = parentNode == null? null:parentNode;
                parentNode = pNode.next == null? null : pNode.next;
            }
            return (parentNode == null || pNode == null) ? null : parentNode;
        }
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}