package com.github.hardwjj.swordoffer.s33;

/**
 * 题： 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
 *
 *  解题思路：
 *     递归考察左右子树
 */
public class Solution {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    /**
     * 输入一个整数序列， first为序列第一个元素的下标,last为序列最后一个元素的下标
     */
    private static boolean verify(int[] sequence, int first, int last){
        // 仅剩下一个元素
        if(last - first <= 1){
            return true;
        }

        // 获取根节点
        int rootVal = sequence[last];
        int curIndex = first;
        // 考察左子树
        while (curIndex < last && sequence[curIndex] < rootVal){
            curIndex++;
        }

        // 考察右子树
        for (int i = curIndex; i < last; i++) {
            if(sequence[i] < rootVal){
                return false;
            }
        }
        // 递归考察左右子树，根节点不包括在内
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST(new int[]{1, 3, 2});
    }
}