package com.github.hardwjj.swordoffer.s31;

import java.util.Stack;

/**
 * 题： 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 *
 *  解题思路：
 *     使用一个栈来模拟压入弹出操作。
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < n; i++) {
            stack.push(pushA[i]);
            // 如果压入栈过程中出现栈顶与弹出栈数组当前遍历元素相同则弹栈，
            // 循环操作直到栈中没有元素或者当前模拟栈栈顶不符合弹出栈数组当前决策值
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}