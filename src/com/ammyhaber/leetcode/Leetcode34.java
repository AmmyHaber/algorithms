package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;

        if (target < nums[l] || target > nums[r]) {
            return new int[]{-1, -1};
        }

        while (l <= r) {
            int m = (l + r) / 2;
            if (target < nums[m]) {
                r = m - 1;
            } else if (target == nums[m]) {
                int[] result = new int[]{-1, -1};
                int i = m, k = m;
                while (i >= l || k <= r) {
                    if (i>= l && nums[i] == nums[m]) {
                        result[0] = i;
                    }
                    i--;
                    if (k <= r && nums[k] == nums[m]) {
                        result[1] = k;
                    }
                    k++;
                }
                return result;
            } else {
                l = m + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
