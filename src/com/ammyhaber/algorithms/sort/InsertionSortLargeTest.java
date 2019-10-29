package com.ammyhaber.algorithms.sort;

import java.util.Random;

public class InsertionSortLargeTest {

    public static void main(String[] args) {
        /*
         *
         * for j=2 to A.length
         *     key = A[j]
         *     i = j - 1
         *     while i > 0 and A[i] > key
         *         A[i+1] = A[i]
         *         i = i - 1
         *     A[i+1] = key
         *
         * 插入排序适合排序少量数据，对大量数据的排序效率非常低
         *
         * */
        long startAt = System.currentTimeMillis();
        int[] arr = new int[100000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(Integer.MAX_VALUE);
        }
        int key, i;
        long sortAt = System.currentTimeMillis();
        for (int j = 1; j < arr.length; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        long endAt = System.currentTimeMillis();
        System.out.println("运行时间：" + (endAt - startAt));
        System.out.println("排序时间：" + (endAt - sortAt));
    }
}
