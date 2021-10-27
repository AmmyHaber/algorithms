package com.ammyhaber.leetcode;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Leetcode53 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray2(arr);
        System.out.println(max);
    }

    /**
     * 动态规划
     * f(i)表示以nums[i]结尾连续子数组的最大和。
     * 结果就是要求出最大的f(i)，其中0<i<n-1
     * 得出状态转移方程 ==> f(i) = max{f{i-1} + nums[i], nums[i]}
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    /**
     * 使用分治法，将数组分成左右两个子数组。
     * 每个被拆分的数组，都要记录四个值：
     * leftSum: 从左边第一个元素为左边界的最大连续子数组的和
     * rightSum: 从右边第一个元素为右边界的最大连续子数组的和
     * totalSum: 数组所有元素的总和
     * maxSum: 最大连续子数组的和
     *
     * 数组的这四个值，可以通过自己的左右两个子数组的这四个值分别得出。
     * 当拆分到数组只有一个元素时，这四个值即为该元素的值。然后递归开始回归。
     * 最后得出原数组的maxSum即为答案。
     */
    public static int maxSubArray2(int[] nums) {
        return maxSubArray2OfRange(nums, 0, nums.length - 1).maxSum;
    }

    private static Status maxSubArray2OfRange(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        Status leftStatus = maxSubArray2OfRange(nums, l, m);
        Status rightStatus = maxSubArray2OfRange(nums, m + 1, r);
        int leftSum = Math.max(leftStatus.leftSum, leftStatus.totalSum + rightStatus.leftSum);
        int rightSum = Math.max(rightStatus.rightSum, rightStatus.totalSum + leftStatus.rightSum);
        int totalSum = leftStatus.totalSum + rightStatus.totalSum;
        int maxSum = Math.max(leftStatus.rightSum + rightStatus.leftSum, Math.max(leftStatus.maxSum, rightStatus.maxSum));
        return new Status(leftSum, rightSum, maxSum, totalSum);
    }

    static class Status {
        int leftSum;
        int rightSum;
        int maxSum;
        int totalSum;

        Status(int leftSum, int rightSum, int maxSum, int totalSum) {
            this.leftSum = leftSum;
            this.rightSum = rightSum;
            this.maxSum = maxSum;
            this.totalSum = totalSum;
        }
    }
}
