package com.ammyhaber.leetcode;

public class Leetcode1248_ {

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
        System.out.println(numberOfSubarrays(new int[]{2,2,1,1,2,1,1,2,2}, 3));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,1,2}, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }

}
