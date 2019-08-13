package com.github.hardwjj.swordoffer.s17;

/**
 * 题： 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 *
 * 解：
 *  由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 *  使用回溯法得到所有的数。
 *
 */
public class Solution {

    public void print1ToMaxOfNDigits(int n) {
        if(n <= 0){
            return;
        }

        // 存放位数
        char[] numbers = new char[n];
        print1ToMaxOfNDigits(numbers, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        // 已经达到三位可以打印
        if(digit == number.length){
            printNumber(number);
            return;
        }

        // 深度优先 000 001 002
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        // 打印前去掉前面的0
        int index = 0;
        while (index < number.length && number[index] == '0'){
            index++;
        }

        while (index < number.length){
            System.out.print(number[index++]);
        }

        System.out.println();
    }

}