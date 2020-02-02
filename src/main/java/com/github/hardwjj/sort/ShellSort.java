package com.github.hardwjj.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author wjiajun
 */
public class ShellSort {

    private static void sort(int[] array) {
        int dk = array.length / 2;
        while (dk >= 1) {
            shellSort(array, dk);
            dk = dk / 2;
        }
    }

    private static void shellSort(int[] array, int dk) {
        for (int i = dk; i < array.length; i++) {
            // 顺序不符
            if(array[i - dk] > array[i]) {
                int temp = array[i];
                int j;
                for (j = i - dk; j >= 0 && array[j] > temp; j = j - dk) {
                    array[j + dk] = array[j];
                }
                array[j + dk] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
