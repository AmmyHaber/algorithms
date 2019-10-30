package com.ammyhaber.algorithms.sort.insertion;

import java.util.Arrays;

/**
 * use recursive procedure as a insertion sort
 */
public class RecursiveInsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 7, 1, 3, 2, 6};
        sort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * use recursive and insertion sort to sort a subarray A[0..n].
     * first use sort method to make subarray A[0..n-1] to be sorted,
     * then insert index n element into a right position into A[0..n-1].
     * @param arr arr array need to be sorted
     * @param n a index, after sort, subarray A[0..n] will be sorted
     *
     * *******  pseudocode for sort(A, n)  *******
     *      1.  if n > 0
     *      2.      sort(A, n - 1)
     *      3.      insert(A, n)
     * *********************************************
     */
    static void sort(int[] arr, int n) {
        if (n > 0) {
            sort(arr, n - 1);
            insert(arr, n);
        }
    }

    /**
     * insert the index n element into sorted subarray A[0..n-1].
     * after insert, it will make a sorted subarray A[0..n]
     * @param arr array need to be sorted
     * @param n the index need to be insert into the sorted subarray A[0..n-1]
     *
     * *******  pseudocode for insert(A, n)  *******
     *      1.  key = A[n]
     *      2.  k = n - 1
     *      3.  while k >= 0 and key < A[k]
     *      4.      A[k + 1] = A[k]
     *      5.      k = k - 1
     *      6.  A[k + 1] = key
     * *********************************************
     */
    private static void insert(int[] arr, int n) {
        int key = arr[n];
        int k = n - 1;
        while (k >= 0 && key < arr[k]) {
            arr[k + 1] = arr[k];
            k--;
        }
        arr[k + 1] = key;
    }
}
