package com.ammyhaber.leetcode;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Leetcode136 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }

    /**
     * 数组中所有元素做异或运算的结果，即为唯一只出现一次的数字。
     * 因为异或运算满足交换律。而相同数字异或运算的结果等于0。而和0做异或运算的任何数字都等于其本身。
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
