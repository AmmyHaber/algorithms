package com.ammyhaber.leetcode;

public class Leetcode33 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(arr, 8));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        if (l == r) {
            if (nums[l] == target) {
                return l;
            } else {
                return -1;
            }
        }
        int m = (l + r) / 2;
        if (nums[l] > nums[m]) {
            // 最小值在左边
            if (target >= nums[m] && target <= nums[r]) {
                return binarySearch(nums, m, r, target);
            } else {
                return binarySearch(nums, l, m, target);
            }
        } else {
            // 最小值在右边
            if (target >= nums[l] && target <= nums[m]) {
                // 目标值在左边
                return binarySearch(nums, l, m, target);
            } else {
                return binarySearch(nums, m + 1, r, target);
            }
        }
    }
}
