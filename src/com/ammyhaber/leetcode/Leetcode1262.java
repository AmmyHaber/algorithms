package com.ammyhaber.leetcode;

public class Leetcode1262 {

    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(maxSumDivThree(new int[]{4}));
        System.out.println(maxSumDivThree(new int[]{1,2,3,4,4}));
        System.out.println(maxSumDivThree(new int[]{2,6,2,2,7}));
    }

    public static int maxSumDivThree(int[] nums) {
        int[] remainder = new int[3];
        for (int num : nums) {
            int a, b, c;
            a = remainder[0] + num;
            b = remainder[1] + num;
            c = remainder[2] + num;
            remainder[a % 3] = Math.max(remainder[a % 3], a);
            remainder[b % 3] = Math.max(remainder[b % 3], b);
            remainder[c % 3] = Math.max(remainder[c % 3], c);
        }
        return remainder[0];
    }
}
