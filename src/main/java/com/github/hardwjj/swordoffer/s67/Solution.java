package com.github.hardwjj.swordoffer.s67;

public class Solution {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';

        int ret = 0;

        for (int i = 0; i < str.toCharArray().length; i++) {
            if(i == 0 && str.charAt(i) == '-' || str.charAt(i) == '+') {
                continue;
            }

            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }

            ret = ret * 10 + (str.charAt(i) - '0');
        }
        return isNegative == true ? -ret : ret;
    }
}