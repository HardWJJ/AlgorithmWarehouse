package com.github.hardwjj.swordoffer.s6;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

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