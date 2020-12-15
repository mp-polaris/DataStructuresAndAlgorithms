package com.polaris.algorithms.sorting;

import com.polaris.utils.Integers;

public class Sort {
    public static void main(String[] args) {
        Integer[] arr1 = Integers.random(10, 0, 100);
        Integer[] sortedArr1 = bubbleSort(arr1);
        Integers.println(sortedArr1);
    }

    /**
     * 分析：
     */
    public static Integer[] bubbleSort(Integer[] arr) {
        int temp = 0;
        for (int end = arr.length - 1; end > 0; end--)
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        return arr;
    }
}
