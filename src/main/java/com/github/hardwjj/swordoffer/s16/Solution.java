package com.github.hardwjj.swordoffer.s16;

/**
 * 题： 数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 *
 * 解：
 *  x 代表 base，n 代表 exponent。
 *
 *  x^n{
 *      (x * x)^(n / 2)             n % 2 = 0
 *      x * (x * x)^(n / 2)         n % 2 = 1
 *  }
 *
 */
public class Solution {
    public double Power(double base, int exponent) {

        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }

        boolean isNegative = false;
        if(exponent < 0){
            exponent = -exponent;
            isNegative = true;
        }

        // 递归缩小范围
        double pow = Power(base * base, exponent / 2);
        // 指数不为偶数需要再与一个基数相乘
        if(exponent % 2 != 0){
            pow = pow * base;
        }
        // 指数的正负
        return isNegative? 1 / pow : pow;
  }
}