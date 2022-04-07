package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        for (int i = 0, j = 0, k = 0; k < m + n; k++) {
            if (j >= n || (i < m && copy[i] < nums2[j])) {
                nums1[k] = copy[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }
}
