package com.ammyhaber.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Leetcode121 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        return maxProfit2(prices, 0, prices.length - 1);
    }

    private static int maxProfit2(int[] prices, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) >> 1;

        return Math.max(Math.max(maxProfit2(prices, l, m), maxProfit2(prices, m + 1, r)), maxInArray(prices, m + 1, r) - minInArray(prices, l, m));
    }

    private static int maxInArray(int[] arr, int l, int r) {
        int max = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int minInArray(int[] arr, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
