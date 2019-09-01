package com.github.hardwjj.sort.bubble;

/**
 * 选择排序
 * @author wjiajun
 */
public class SelectSort {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param array
     */
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            // 存储最小值下标
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]){
                    // 找出最小值
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
