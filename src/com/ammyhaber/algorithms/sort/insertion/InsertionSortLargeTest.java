package com.ammyhaber.algorithms.sort.insertion;

import com.ammyhaber.algorithms.sort.RandomArrayMaker;

/**
 * insertion sort is not fast in large size array test ,but ok in a very small size array.
 * and it use little memory
 */
public class InsertionSortLargeTest {

    public static void main(String[] args) {
        long startAt = System.currentTimeMillis();
        int[] arr = RandomArrayMaker.make(100000);
        long sortAt = System.currentTimeMillis();
        InsertionSort.insertionSort(arr);
        long endAt = System.currentTimeMillis();
        System.out.println("running time：" + (endAt - startAt));
        System.out.println("sorting time：" + (endAt - sortAt));
    }
}
