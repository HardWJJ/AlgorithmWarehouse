package com.github.hardwjj.swordoffer.s24;

/**
 * 题： 反转链表
 *
 *  解题思路：
 *     解1：
 *          使用递归
 *     解2：
 *          使用头插法
 */
public class Solution {

    /**
     * 传入当前链表头指针返回翻转后的链表的头指针
     * example: a -> b -> c
     *  传入a
     *  a <- b <- c
     *  返回 c
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 获取下一个节点
        ListNode next = head.next;
        // 将下一节点置空
        head.next = null;
        // 调用递归;
        ListNode newHead = ReverseList(next);
        // 进行反转
        next.next = head;
        return newHead;
    }

    /**
     *
     * 头插法
     *
     *
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null){
            ListNode next = head.next;
            // 将当前节点的后指针指向新链表的头节点的下一个元素
            head.next = newList.next;
            // 新链表的下一个节点赋值为头节点
            newList.next = head;
            // 继续考察下一个节点
            head = next;
        }
        return newList.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}