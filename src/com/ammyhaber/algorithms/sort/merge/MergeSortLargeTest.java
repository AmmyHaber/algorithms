package com.ammyhaber.algorithms.sort.merge;

import java.util.Random;

public class MergeSortLargeTest {
    public static void main(String[] args) {
        long startAt = System.currentTimeMillis();
        int[] arr = new int[100000000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(Integer.MAX_VALUE);
        }
        long sortAt = System.currentTimeMillis();
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        long endAt = System.currentTimeMillis();
        System.out.println("运行时间：" + (endAt - startAt));
        System.out.println("排序时间：" + (endAt - sortAt));
    }
}
