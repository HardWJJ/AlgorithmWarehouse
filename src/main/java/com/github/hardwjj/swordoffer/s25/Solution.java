package com.github.hardwjj.swordoffer.s25;

/**
 * 题： 合并两个排序的链表
 *
 *  解题思路：
 *     解1：
 *          递归
 *     解2：
 *          迭代
 */

public class Solution {

    /**
     * 递归
     *
     *  返回两个链表合并结果的头指针。
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else  {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     *
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (list1 != null && list2 != null){
            // 对比链表大小合并链表
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null){
            cur.next = list2;
        }
        if(list2 == null){
            cur.next = list1;
        }
        return head.next;
    }



}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}