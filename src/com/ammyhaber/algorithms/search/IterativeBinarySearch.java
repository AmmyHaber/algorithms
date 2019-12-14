package com.ammyhaber.algorithms.search;

import com.ammyhaber.algorithms.sort.RandomArrayMaker;
import com.ammyhaber.algorithms.sort.insertion.InsertionSort;

import java.util.Arrays;

/**
 * @author ammyhaber
 * @version 1.0
 * @date 2019/12/14
 */
public class IterativeBinarySearch {

    public static void main(String[] args) {
        int[] a = RandomArrayMaker.make(16);
        InsertionSort.insertionSort(a);
        System.out.println(Arrays.toString(a));
        int b = a[10];
        int i = binarySearch(a, b);
        if (i == -1)
            System.out.println(String.format("%d is not in the array", b));
        else
            System.out.println(String.format("Search %d from array a, the index:%d", b, i));
    }

    private static int binarySearch(int[] a, int b) {
        int start = 0;
        int end = a.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] == b)
                return mid;
            if (a[mid] > b)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
