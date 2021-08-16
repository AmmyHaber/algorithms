package com.ammyhaber.algorithms.sort.quick;

import com.ammyhaber.algorithms.sort.RandomArrayMaker;

public class QuickSortLargeTest {

    public static void main(String[] args) {
        long startAt = System.currentTimeMillis();
        int[] arr = RandomArrayMaker.make(100000000);
        long sortAt = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long endAt = System.currentTimeMillis();
        System.out.println("running time：" + (endAt - startAt));
        System.out.println("sorting time：" + (endAt - sortAt));
    }
}
