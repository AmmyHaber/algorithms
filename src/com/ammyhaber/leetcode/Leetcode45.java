package com.ammyhaber.leetcode;

public class Leetcode45 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{1, 1, 1, 1, 2, 3, 0, 1, 4}));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int end = nums.length - 1;
        int tmpEnd = end;
        int ans = 0;
        while (tmpEnd > 0) {
            for (int i = end - 1; i >= 0; i--) {
                if ((i + nums[i]) >= end) {
                    tmpEnd = i;
                }
            }
            end = tmpEnd;
            ans++;
        }
        return ans;
    }
}
