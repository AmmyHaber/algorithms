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

    static void sort(int[] arr, int n) {
        if (n > 0) {
            sort(arr, n - 1);
            insert(arr, n);
        }
    }

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
