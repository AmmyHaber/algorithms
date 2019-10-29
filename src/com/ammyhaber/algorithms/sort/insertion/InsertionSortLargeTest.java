package com.ammyhaber.algorithms.sort.insertion;

import java.util.Random;

/**
 * insertion sort is not fast in large size array test ,but ok in a very small size array.
 * and it use little memory
 */
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
         * */
        long startAt = System.currentTimeMillis();
        int[] arr = new int[100000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(Integer.MAX_VALUE);
        }
        long sortAt = System.currentTimeMillis();
        InsertionSort.insertionSort(arr);
        long endAt = System.currentTimeMillis();
        System.out.println("running time：" + (endAt - startAt));
        System.out.println("sorting time：" + (endAt - sortAt));
    }
}
