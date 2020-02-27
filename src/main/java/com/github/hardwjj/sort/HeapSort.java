package com.github.hardwjj.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author wjiajun
 */
public class HeapSort {

    public static void sort(int[] array){
        // 构建堆
        int N = array.length - 1;
        // 从右往左，第一个非叶子节点的开始下推构建堆，因为这样下沉操作可以使这个节点为根节点的子堆有序，
        // 所以到更上层下推时，除了该上层节点外，其他的子节点为根节点构成的节点已经有序了
        for (int k = N / 2; k >= 1; k--) {
            sink(array, k ,N);
        }

        // 排序
        // 将最后一个节点与堆顶元素交换，然后长度缩小，交换后，堆顶进行下推，当堆大小缩小为1时，整个数组已经从小到大递增排序了
        while (N > 1) {
            // 交换旧堆顶元素，并减小堆大小
            swap(array, 1, N--);
            // 堆顶元素下推
            sink(array, 1, N);
        }
    }

    // 下沉操作 O(logn)
    private static void sink(int[] nums, int k, int N) {
        // 判断该节点k的子节点是否超出最大的范围
        while (2 * k <= N) {
            // 获取左子节点
            int j = 2 * k;
            // 获取k的左右子节点中最大的一个
            // 由于2 * k <= N的保障，所以这里只需要校验左子节点j，右子节点可能等于N，当树为满二叉树时
            if(j < N && nums[j] < nums[j +1]) {
                j = j + 1;
            }
            // 该节点K已经是最大的了，不用下推了
            if(nums[j] < nums[k]) {
                break;
            }
            // 交换
            swap(nums, k, j);
            // 继续下沉k节点
            k = j;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
