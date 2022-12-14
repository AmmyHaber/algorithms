package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode283 {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        int[] b = new int[]{0, 1, 3, 0, 3, 7, 0, 5, 12};
        moveZeroes(b);
        System.out.println(Arrays.toString(b));
        int[] c = new int[]{0};
        moveZeroes(c);
        System.out.println(Arrays.toString(c));
        int[] d = new int[]{1};
        moveZeroes(d);
        System.out.println(Arrays.toString(d));
        int[] e = new int[]{1, 0, 1};
        moveZeroes(e);
        System.out.println(Arrays.toString(e));
        int[] f = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeroes(f);
        System.out.println(Arrays.toString(f));
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
