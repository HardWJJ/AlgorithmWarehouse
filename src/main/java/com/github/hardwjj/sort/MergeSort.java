package com.github.hardwjj.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author wjiajun
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * 时间复杂度 O(nlogn)
     * 空间复杂度O(n)
     *
     * @param array
     */
    public static void sort(int[] array){
        int[] tempArray = new int[array.length];
        sort(array, tempArray, 0, array.length - 1);
    }

    /**
     * 归并排序
     *
     * @param array
     * @param tempArray
     * @param startIndex
     * @param endIndex
     */
    private static void sort(int[] array, int[] tempArray, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int mid = startIndex + ((endIndex - startIndex) >> 1);
            sort(array, tempArray, startIndex, mid);
            sort(array, tempArray, mid + 1, endIndex);
            merge(array, tempArray, startIndex, mid, endIndex);
        }
    }

    /**
     * 归并
     *
     * @param array
     * @param tempArray
     * @param startIndex
     * @param mid
     * @param endIndex
     */
    private static void merge(int[] array, int[] tempArray, int startIndex, int mid, int endIndex){

        int left = startIndex;
        int right = mid + 1;
        int i = 0;
        while (left <= mid && right <= endIndex){
            if(array[left] <= array[right]){
                tempArray[i++] = array[left++];
            }else {
                tempArray[i++] = array[right++];
            }
        }

        while (left <= mid){
            tempArray[i++] = array[left++];
        }

        while (right <= endIndex){
            tempArray[i++] = array[right++];
        }

        for (int j = 0; j < i; j++) {
            array[startIndex + j] = tempArray[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
