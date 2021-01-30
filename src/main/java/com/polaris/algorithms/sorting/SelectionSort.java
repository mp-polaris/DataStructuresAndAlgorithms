package com.polaris.algorithms.sorting;

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
            swap(maxIndex, eIndex);
        }
    }

}
