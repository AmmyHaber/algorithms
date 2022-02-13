package com.ammyhaber.leetcode;

public class Leetcode209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = nums[0];
        int result = 0;
        while (i <= j) {
            if (sum >= target) {
                result = result == 0 ? (j - i + 1) : Math.min(j - i + 1, result);
                sum -= nums[i];
                i++;
            } else {
                j++;
                if (j == nums.length) {
                    break;
                }
                sum += nums[j];
            }
        }
        return result;
    }
}
