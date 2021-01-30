package com.polaris.algorithms.sorting;

import com.polaris.utils.Integers;

/**
 * @Author polaris
 * @Date 2021/1/30 2:16
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] arr = Integers.random(10, 0, 100);
        Integer[] sortedArr = selectSort1(arr);
        Integers.println(sortedArr);
    }

    public static Integer[] selectSort1(Integer[] arr) {
        for (int eIndex = arr.length - 1; eIndex > 0; eIndex--) {
            int maxIndex = 0;
            for (int i = 1;i <= eIndex;i++) {
                //注意：为了稳定性，这里要写 <=
                if(arr[maxIndex] <= arr[i]) {
                    maxIndex = i;
                }
            }
            swap(arr,maxIndex,eIndex);
        }
        return arr;
    }

    public static void swap(Integer[] arr, int index1, int index2) {
        int temp = 0;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
