package com.polaris.algorithms.sorting;

/**
 * @Author polaris
 * @Date 2021/1/31 0:49
 */
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

    /**
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            int cur = i;
            while(cur > 0 && cmp(cur,cur - 1) < 0) {
                swap(cur,cur - 1);
                cur--;
            }
        }
    }
     */

    /** 优化=>将交换转为挪动
    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            int cur = i;
            T val = array[cur];
            while(cur > 0 && cmp(val,array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = val;
        }
    }
     */

    /** 优化 => 二分搜索 */
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            //这里为什么传索引而不是传值？
            // => 传索引还可以知道前面已经排好序的数组区间：[0,i)
            insert(begin,search(begin));
        }
     }

    /** 将source位置的元素插入到dest位置 */
    private void insert(int source,int dest) {
         //将[dest,source)范围内的元素往右边挪动一位
         T val = array[source];
         for (int i = source; i > dest; i--) {
             array[i] = array[i - 1];
         }
         //插入
         array[dest] = val;
     }

    private int search(int index) {
        T val = array[index];
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(cmp(val,array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid  + 1;
            }
        }
        return begin;
    }

    /** 二分搜索-基本实现
     *      查找val在有序数组arr中的位置，找不到就返回-1
     private static int indexOf(Integer[] arr,int val) {
        if(arr == null || arr.length == 0) return -1;
        int begin = 0;
        //注意这里end设计为arr.length便于求数量（end - begin）
        int end = arr.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(val < arr[mid]) {
                end = mid;
            } else if(val > arr[mid]) {
                begin = mid  + 1;
            } else {
                return mid;
            }
        }
        return -1;
     }
     */

    /**
     * 二分搜索-适用于插入排序
     *    查找val在有序数组arr中可以插入的位置
     *    规定：要求二分搜索返回的插入位置是第1个大于 val 的元素位置
     *
    private static int search(Integer[] arr,int val) {
        if(arr == null || arr.length == 0) return -1;
        int begin = 0;
        int end = arr.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(val < arr[mid]) {
                end = mid;
            } else {
                begin = mid  + 1;
            }
        }
        return begin;
    }
     */
}
