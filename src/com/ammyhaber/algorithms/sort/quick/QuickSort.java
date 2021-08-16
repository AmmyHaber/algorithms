package com.ammyhaber.algorithms.sort.quick;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 7, 1, 3, 2, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int s, int e) {
        if (s < e) {
            int p = partition(arr, s, e);
            quickSort(arr, s, p - 1);
            quickSort(arr, p + 1, e);
        }
    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[e];
        int i = s;
        for (int j = s; j < e; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        arr[e] = arr[i];
        arr[i] = pivot;
        return i;
    }
}
