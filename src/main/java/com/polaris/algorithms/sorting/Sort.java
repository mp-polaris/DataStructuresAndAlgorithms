package com.polaris.algorithms.sorting;

import java.text.DecimalFormat;

public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {
    /** 目标数组 */
	protected T[] array;
	/** 比较次数 */
    private int cmpCount;
	/** 交换次数 */
    private int swapCount;
    /** 执行时间 */
    private long time;
    /** 小数格式化 */
    private DecimalFormat fmt = new DecimalFormat("#.00");

	/** 预处理 */
    public void sort(T[] array) {
        if (array == null || array.length < 2) return;
        this.array = array;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

	/** 目标方法 */
	protected abstract void sort();

    /**
     * 比较数组下标对应的值
     *
     * 返回值等于0，代表 array[index1] == array[index2]
     * 返回值小于0，代表 array[index1] < array[index2]
     * 返回值大于0，代表 array[index1] > array[index2]
     */
    protected int cmp(int index1, int index2) {
        cmpCount++;
        return array[index1].compareTo(array[index2]);
    }

	/** 比较值 */
    protected int cmp(T value1, T value2) {
        cmpCount++;
        return value1.compareTo(value2);
    }

	/** 交换值 */
    protected void swap(int index1, int index2) {
        swapCount++;
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    /** 稳定性测试 */
    @SuppressWarnings("unchecked")
    private boolean isStable() {
        Student[] students = new Sort.Student[20];
        for (int i = 0; i < students.length; i++) {
            //（0，10） （10，10） （20，10） （30，10）
            students[i] = new Student(i * 10, 10);
        }
        sort((T[]) students);//只会对年龄进行排序
        for (int i = 1; i < students.length; i++) {
            int score = students[i].score;
            int prevScore = students[i - 1].score;
            if (score != prevScore + 10) return false;
        }
        return true;
    }

    private static class Student implements Comparable<Student>{
        Integer score;
        Integer age;
        public Student(Integer score, Integer age) {
            this.score = score;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            return age - o.age;
        }
    }

    /** 排序方式 */
    @Override
    public int compareTo(Sort o) {
        int result = (int)(time - o.time);
        if(result != 0) return result;
        result = cmpCount - o.cmpCount;
        if(result != 0) return result;
        return swapCount - o.swapCount;
    }

    @Override
    public String toString() {
        return "【" + getClass().getSimpleName() + "】\n"
                + "交换次数 ==> " + numberString(swapCount) + "\n"
                + "比较次数 ==> " + numberString(cmpCount) + "\n"
                + "执行时间 ==> " + time * 0.001 + "s" + "\n"
                + "稳定性 ==> " + isStable() + "\n"
                + "=================================";
    }

    /** 数字格式化 */
    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) {
            return fmt.format(number / 10000.0) + "万";
        }
        return fmt.format(number / 100000000.0) + "亿";
    }

}
