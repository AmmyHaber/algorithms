package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 2; i >= 0; i--) {
            r = r * nums[i + 1];
            ans[i] = r * ans[i];
        }
        return ans;
    }
}
