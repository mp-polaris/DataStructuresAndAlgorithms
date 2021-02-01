package com.polaris.algorithms.sorting;

import com.polaris.utils.Integers;
import org.junit.Test;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    /** 初步实现
    @Override
    public void sort() {
        for (int eIndex = array.length - 1; eIndex > 0; eIndex--) {
            for (int i = 1; i <= eIndex; i++) {
                if (cmp(i, i - 1) < 0) {
                    swap(i, i - 1);
                }
            }
        }
    }
     */

    /** 优化方式一：如果序列已经完全有序，可以提前终止冒泡排序
        缺点：只有当完全有序时才会提前终止冒泡排序
    @Override
    public void sort() {
        for (int eIndex = array.length - 1; eIndex > 0; eIndex--) {
            boolean sorted = true;
            for (int i = 1; i <= eIndex; i++) {
                if (cmp(i,i - 1) < 0) {
                    swap(i, i - 1);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
     */

    /**
     *  优化方式二：如果序列尾部已经局部有序，可以记录最后依次交换的位置，减少比较次数
     *  为什么这里sortedIndex为1（只要保证 eIndex-- > 0 即可）？
     *     => 如果sortedIndex为eIndex，当数组第一次就完全有序时，就退回到最初的版本了
     *     => 如果sortedIndex为1，当数组第一次就完全有序时，一轮扫描就结束了！
     * */
    @Override
    public void sort() {
        for (int eIndex = array.length - 1; eIndex > 0; eIndex--) {
            int sortedIndex = 1; //记录最后一次交换的下标位置
            for (int i = 1; i <= eIndex; i++) {
                if (cmp(i, i - 1) < 0) {
                    swap(i, i - 1);
                    sortedIndex = i;
                }
            }
            eIndex = sortedIndex;
        }
    }

    /** TODO:快速手写 */
    public static void BubbleSort(Integer[] arr) {
        for (int eIndex = arr.length - 1; eIndex > 0 ; eIndex--) {
            int flagIndex = 0;
            for (int i = 1; i <= eIndex; i++) {
                if(arr[i] < arr[i - 1]) {
                    swap(arr,i, i - 1);
                    flagIndex = i;
                }
            }
            eIndex = flagIndex;
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
        BubbleSort(arr);
        Integers.println(arr);
    }
}
