package com.github.hardwjj.swordoffer.s9;

import java.util.Stack;

/**
 * 题：用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *
 *
 * 解：
 * stack1 栈用来处理入栈（push）操作，stack2 栈用来处理出栈（pop）操作。
 * 一个元素进入 stack1 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 stack2 栈，
 * 此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。
 *
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }

        return stack2.pop();
    }
}