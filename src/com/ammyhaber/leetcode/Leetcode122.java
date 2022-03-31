package com.ammyhaber.leetcode;

public class Leetcode122 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                int j = i + 1;
                while (j < prices.length - 1 && prices[j] < prices[j + 1]) {
                    j++;
                }
                profit += prices[j] - prices[i];
                i = j;
            }
        }
        return profit;
    }
}
