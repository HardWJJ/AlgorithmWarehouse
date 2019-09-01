package com.github.hardwjj.sort.bubble;

import java.util.Arrays;

/**
 * 插入排序
 * @author wjiajun
 */
public class InsertSort {


    /**
     * 时间复杂度 最好情况下：O(n) 最坏情况下：O(n^2)
     * 空间复杂度O(1)
     *
     * 从小到大排序
     * @param array
     */
    public static void sort(int[] array){
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if(array[j] > value){
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
