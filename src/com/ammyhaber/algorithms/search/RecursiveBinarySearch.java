package com.ammyhaber.algorithms.search;

import com.ammyhaber.algorithms.sort.RandomArrayMaker;
import com.ammyhaber.algorithms.sort.insertion.InsertionSort;

import java.util.Arrays;

/**
 * @author ammyhaber
 * @version 1.0
 * @date 2019/12/14
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] a = RandomArrayMaker.make(16);
        InsertionSort.insertionSort(a);
        System.out.println(Arrays.toString(a));
        int b = a[11];
        int i = binarySearch(a, 0, a.length - 1, b);
        if (i == -1)
            System.out.printf("%d is not in the array%n", b);
        else
            System.out.printf("Search %d from array a, the index:%d%n", b, i);
    }

    private static int binarySearch(int[] a, int l, int r, int b) {
        if (l > r)
            return -1;
        int m = (l + r) / 2;
        if (a[m] == b)
            return m;
        else if (a[m] > b)
            return binarySearch(a, l, m - 1, b);
        else
            return binarySearch(a, m + 1, r, b);
    }
}
