package com.polaris.algorithms.sorting;

import com.polaris.utils.Integers;
import org.junit.Test;

/**
 * @Author polaris
 * @Date 2021/1/30 2:16
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort() {
        for (int eIndex = array.length - 1; eIndex > 0; eIndex--) {
            int maxIndex = 0;
            for (int i = 1; i <= eIndex; i++) {
                //注意：为了稳定性，这里要写 <=
                if (cmp(maxIndex, i) <= 0) {
                    maxIndex = i;
                }
            }
            if(maxIndex != eIndex) swap(maxIndex, eIndex);
        }
    }

    /** TODO:手写 */
    public static void SelectionSort(Integer[] arr) {
        for (int eIndex = arr.length - 1; eIndex > 0 ; eIndex--) {
            int maxValIndex = 0;
            for (int i = 1; i <= eIndex; i++) {
                if(arr[maxValIndex] <= arr[i]) {
                    maxValIndex = i;
                }
            }
            if(maxValIndex != eIndex) swap(arr,maxValIndex,eIndex);
        }
    }

    private static void swap(Integer[] arr,int index1,int index2) {
        Integer temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    @Test
    public void test() {
        Integer[] arr = Integers.random(5, 1, 10);
        SelectionSort(arr);
        Integers.println(arr);
    }
}
