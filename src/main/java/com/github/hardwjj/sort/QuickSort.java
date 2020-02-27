package com.github.hardwjj.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 * @author wjiajun
 */
public class QuickSort {

    public static void sort(Integer[] arr) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Integer[] arr, int l, int h) {
        if(l >= h){
            return;
        }
        int j = partition(arr, l, h);
        sort(arr, l, j - 1);
        sort(arr, j + 1, h);
    }

    // 获取返回基准元素，使得基准元素左边都小于该元素，右边都大于该元素
    private static int partition(Integer[] arr, int l, int h) {
        int i = l, j = h + 1;
        int v = arr[l];
        while (true) {
            while (arr[++i] < v && i != h){}
            while (arr[--j] > v && j != l){}
            if(i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void shuffle(Integer[] arr){
        // 将元素打乱，防止元素一开始就有序，导致算法复杂度上升到O(n^2)
        List<Integer> list =  Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
