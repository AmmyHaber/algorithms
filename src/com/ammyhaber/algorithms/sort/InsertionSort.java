package com.ammyhaber.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {

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
         * */
        int[] arr = {31, 41, 59, 26, 41, 58};
        int key, i;
        for (int j = 1; j < arr.length; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
