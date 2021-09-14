package com.ammyhaber.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class Leetcode4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double medianValue = findMedianSortedArrays(nums1, nums2);
        assert medianValue == 2.0000;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];
        for (int k = 0, i = 0, j = 0; k < nums1.length + nums2.length; k++) {
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                a[k] = nums1[i];
                i++;
            } else if (j < nums2.length){
                a[k] = nums2[j];
                j++;
            }
        }
        if (a.length % 2 == 0) {
            // 偶数
            return (a[a.length / 2] + a[a.length / 2 - 1]) / 2f;
        } else {
            return a[(a.length - 1) / 2];
        }
    }
}
