package com.github.hardwjj.swordoffer.s30;


import java.util.Stack;

/**
 * 题： 包含 min 函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 *
 *  解题思路：
 *     维护一个数据栈和一个最小栈
 */
public class Solution {

    private Stack<Integer> dataStack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    
    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty()? node : Math.min(minStack.peek(), node));
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}