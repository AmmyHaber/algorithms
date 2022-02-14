package com.ammyhaber.leetcode;

public class Leetcode1004 {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0));
    }

    /**
     * 虽然做出来了，但是代码太丑了。看题解的代码吧。
     */
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int result = 0;
        while (l <= r && r < nums.length) {
            while (r < nums.length && (k > 0 || nums[r] == 1)) {
                r++;
                if (nums[r - 1] == 0) {
                    k--;
                }
            }
            if (l == r) {
                while (l < nums.length && nums[l] == 0) {
                    l++;
                }
                r = l;
            } else {
                result = Math.max(result, r - l);
                if (r < nums.length) {
                    // 将l移动到离l最近的0的后面一位
                    while (l < r - 1 && nums[l] == 1) {
                        l++;
                    }
                    l++;
                    if (l < r) {
                        k++;
                    }
                }
            }
       }
        return result;
    }
}
