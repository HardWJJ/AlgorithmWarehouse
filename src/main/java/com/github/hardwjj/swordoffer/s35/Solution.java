package com.github.hardwjj.swordoffer.s35;


/**
 * 题： 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
 *
 *  解题思路：
 *     第一步，在每个节点的后面插入复制的节点。
 *     第二步，对复制节点的 random 链接进行赋值。
 *     第三步，拆分。
 *
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }

        // 第一步：插入新节点，在原节点后面插入复制节点
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode cloneNode = new RandomListNode(cur.label);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        // 第二步：对复制节点的 random 链接进行赋值
        cur = pHead;
        while (cur != null){
            RandomListNode cloneNode = cur.next;
            if(cur.random != null){
                cloneNode.random = cur.random.next;
            }
            cur = cloneNode.next;
        }

        // 第三步：拆分，逐个拆分原链和复制链
        cur = pHead;
        RandomListNode cloneHead = cur.next;
        while (cur.next != null){
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
