package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode1262 {

    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(maxSumDivThree(new int[]{4}));
        System.out.println(maxSumDivThree(new int[]{1,2,3,4,4}));
        System.out.println(maxSumDivThree(new int[]{2,6,2,2,7}));
    }

    public static int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int result = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i] % 3;
            if (m == 0) {
                result += nums[i];
            } else {
                k += nums[i];
            }
            arr[i] = m;
        }
        int n = k % 3;
        int a = 0, b = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (c == 2 && b <= nums[i]) {
                a = nums[i];
                break;
            }
            if (arr[i] == n) {
                a = nums[i];
                break;
            } else {
                if (c < 2) {
                    b += nums[i];
                    c++;
                }
            }
        }
        if (c == 2) {
            return result + k - Math.min(a, b);
        }
        return result + k - a;
    }
}
