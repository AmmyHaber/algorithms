package com.ammyhaber.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 31. 下一个排列
 * <p>
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Leetcode31 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3};
        nextPermutation(a1);
        System.out.println();
        int[] a2 = new int[]{3, 2, 1};
        nextPermutation(a2);
        System.out.println();
        int[] a3 = new int[]{1, 3, 2};
        nextPermutation(a3);
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 2, j = nums.length - 1; i >= -1; i--, j--) {
            if (i < 0 || nums[i] < nums[j]) {
                // reverse j - end
                reverse(nums, j, nums.length - 1);
                // 找到比nums[i]
                if (i >= 0) {
                    for (int k = j; k < nums.length; k++) {
                        if (nums[i] < nums[k]) {
                            int tmp = nums[i];
                            nums[i] = nums[k];
                            nums[k] = tmp;
                            return;
                        }
                    }
                }
                return;
            }
        }
    }

    private static void reverse(int[] nums, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
