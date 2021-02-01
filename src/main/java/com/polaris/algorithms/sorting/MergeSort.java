package com.polaris.algorithms.sorting;

@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    private T[] leftArr;

    @Override
    protected void sort() {
        leftArr = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /** 对 [begin,end) 位置的元素进行归并排序 */

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /** 将 [begin,mid) 和 [mid,end) 范围的序列合并成一个有序序列 */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        //备份左边数组
        for (int i = 0; i < le; i++) {
            leftArr[i] = array[begin + i];
        }

        //如果左边还没有结束（情况一）
        while (li < le) {
            //当 ri < re 不成立，就会一直leftArr挪动（情况二）
            if (ri < re && cmp(array[ri],leftArr[li]) < 0) {
                array[ai++] = array[ri++];
            } else { //注意稳定性
                array[ai++] = leftArr[li++];
            }
        }
    }
}