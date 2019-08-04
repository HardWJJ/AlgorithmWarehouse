package com.github.hardwjj.swordoffer.s8;

public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null){
            TreeLinkNode rightNode = pNode.right;
            while (rightNode.left != null){
                rightNode = rightNode.left;
            }
            return rightNode;
        }else {
            TreeLinkNode parentNode = pNode.next;
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