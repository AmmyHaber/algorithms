package com.ammyhaber.leetcode;

public class Leetcode724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{-1, -1, 0, 0, -1, -1}));
    }

    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        int rightSum = total - leftSum;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
