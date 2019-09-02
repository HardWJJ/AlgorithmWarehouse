package com.github.hardwjj.sort;

import java.util.Arrays;

/**
 *
 * 冒泡排序
 * @author wjiajun
 */
public class BubbleSort {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param array
     */
    public static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 针对有序场景进行优化，如果一开始或者过程中已经有序则直接退出减轻时间复杂度
     *
     * @param array
     */
    public static void sortImprove(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
