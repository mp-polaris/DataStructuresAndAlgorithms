package com.polaris.algorithms.sorting;

import com.polaris.utils.Integers;

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = Integers.random(10, 0, 100);
        Integer[] sortedArr = bubbleSort3(arr);
        Integers.println(sortedArr);
    }

    public static void swap(Integer[] arr, int index1, int index2) {
        int temp = 0;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //初步实现
    public static Integer[] bubbleSort1(Integer[] arr) {
        for (int eIndex = arr.length - 1; eIndex > 0; eIndex--) {
            for (int i = 1; i <= eIndex; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
        }
        return arr;
    }

    //优化方式一：如果序列已经完全有序，可以提前终止冒泡排序
    //缺点：只有当完全有序时才会提前终止冒泡排序
    public static Integer[] bubbleSort2(Integer[] arr) {
        for (int eIndex = arr.length - 1; eIndex > 0; eIndex--) {
            boolean sorted = true;
            for (int i = 1; i <= eIndex; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    sorted = false;
                }
            }
            if(sorted) break;
        }
        return arr;
    }

    //优化方式二：如果序列尾部已经局部有序，可以记录最后依次交换的位置，减少比较次数

    /*
     *  为什么这里sortedIndex为1（只要保证 eIndex-- > 0 即可）？
     *     => 如果sortedIndex为eIndex，当数组第一次就完全有序时，就退回到最初的版本了
     *     => 如果sortedIndex为1，当数组第一次就完全有序时，一轮扫描就结束了！
     */
    public static Integer[] bubbleSort3(Integer[] arr) {
        for (int eIndex = arr.length - 1; eIndex > 0; eIndex--) {
            int sortedIndex = 1; //记录最后一次交换的下标位置
            for (int i = 1; i <= eIndex; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    sortedIndex = i;
                }
            }
            eIndex = sortedIndex;
        }
        return arr;
    }
}
