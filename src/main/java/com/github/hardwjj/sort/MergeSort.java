package com.github.hardwjj.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author wjiajun
 */
public class MergeSort {

    static int[] temp;

    /**
     * 归并排序
     *
     * 时间复杂度 O(nlogn)
     * 空间复杂度O(n)
     *
     * @param array
     */
    public static void sort(int[] array){
        temp = new int[array.length];
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }
        int mid = l + ((h - l) >> 1);
        sort(array, l, mid);
        sort(array, mid + 1, h);
        merge(array, l, mid, h);
    }

    public static void merge(int[] array, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            temp[k] = array[k];
        }

        for (int k = l; k <= h; k++) {
            if(i > m) {
                array[k] = temp[j++];
            }else if(j > h) {
                array[k] = temp[i++];
            }else if(temp[i] < temp[j]) {// 保证稳定性
                array[k] = temp[i++];
            }else {
                array[k] = temp[j++];
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
