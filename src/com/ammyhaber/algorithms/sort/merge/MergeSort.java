package com.ammyhaber.algorithms.sort.merge;

import java.util.Arrays;

/**
 * merge sort
 * merge sort is very fast, but use much memory
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 7, 1, 3, 2, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * sorted subarray[indexStart..indexEnd] by merge sort
     * @param arr array need to be sorted
     * @param indexStart start index
     * @param indexEnd end index
     */
    static void mergeSort(int[] arr, int indexStart, int indexEnd) {
        /*
        mergeSort(A, s, e)
        if s < e
            m = (s + e) / 2
            mergeSort(A, s, m)
            mergeSort(A, m + 1, e)
            merge(A, s, m, e)
         */
        if (indexStart < indexEnd) {
            int indexMid = (indexStart + indexEnd) / 2;
            mergeSort(arr, indexStart, indexMid);
            mergeSort(arr, indexMid + 1, indexEnd);
            merge(arr, indexStart, indexMid, indexEnd);
        }
    }

    /**
     * merge the two sorted subarray into a sorted array
     * @param arr array need to be sorted
     * @param indexStart start index
     * @param indexMid mid index
     * @param indexEnd end index
     */
    static void merge(int[] arr, int indexStart, int indexMid, int indexEnd) {
        /*
        merge(A, s, m, e)
        n1 = m - s + 1
        n2 = e - m
        let L[1..n1] and R[1..n2] be new arrays
        for i = 1 to n1
            L[i] = A[s + i - 1]
        for j = 1 to n2
            R[i] = A[m + j]
        i = 1
        j = 1
        for k = s to e
            if j > n2 or (i <= n1 and L[i] < R[j])
                A[k] = L[i]
                i = i + 1
            else
                A[k] = R[j]
                j = j + 1
         */
        int leftSize = indexMid - indexStart + 1;
        int rightSize = indexEnd - indexMid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[indexStart + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = arr[indexMid + 1 + j];
        }
        int i = 0;
        int j = 0;
        for (int k = indexStart; k <= indexEnd; k++) {
            if (j > rightSize - 1 || (i <= leftSize - 1 && left[i] < right[j])) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }
}
