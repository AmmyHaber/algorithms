package com.ammyhaber.algorithms.sort.merge;

import com.ammyhaber.algorithms.sort.RandomArrayMaker;

public class MergeSortLargeTest {
    public static void main(String[] args) {
        long startAt = System.currentTimeMillis();
        int[] arr = RandomArrayMaker.make(100000000);
        long sortAt = System.currentTimeMillis();
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        long endAt = System.currentTimeMillis();
        System.out.println("running time：" + (endAt - startAt));
        System.out.println("sorting time：" + (endAt - sortAt));
    }
}
