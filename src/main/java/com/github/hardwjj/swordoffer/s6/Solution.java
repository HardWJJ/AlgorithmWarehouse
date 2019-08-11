package com.github.hardwjj.swordoffer.s6;


import java.util.ArrayList;

/**
 * 题：从尾到头打印链表
 * 题目描述
 * 从尾到头反过来打印出每个结点的值。
 *
 *
 * 解：
 * 递归：要逆序打印链表 1->2->3（3,2,1)，先逆序打印链表2->3（3,2)，然后再打印1，然后将问题缩小2->3看成一个新的链表，然后继续调用自己
 *
 * 使用头插法：头结点和第一个节点的区别：
 * 头结点是在头插法中使用的一个额外节点，这个节点不存储值(-1)；
 * 第一个节点就是链表的第一个真正存储值的节点。
 *
 * 使用栈：栈具有后进先出的特点，在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序。
 *
 */
public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode != null){
            list.addAll(printListFromTailToHead(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }

}

class ListNode {

    int val;
    ListNode next = null;
    ListNode(int val) { this.val = val; }

}