package com.github.hardwjj.swordoffer.s18z2;

/**
 * 题： 删除链表中重复的结点
 *
 *
 * 解：
 *  递归删除重复节点
 *
 */
public class Solution {

    /**
     * 输入节点链表，去除所有重复节点返回
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        // 节点数为1或者空
        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode next = pHead.next;
        if(pHead.val == next.val){
            // 当前节点与下一个节点相同，到重复节点过滤到跳出
            while (next != null && pHead.val == next.val){
                // 过滤重复节点
                next = next.next;
            }
            // 返回去除重复节点后的第一个
            return deleteDuplication(next);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}