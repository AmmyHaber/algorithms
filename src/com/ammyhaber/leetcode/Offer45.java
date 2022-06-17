package com.ammyhaber.leetcode;

public class Offer45 {

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(minNumber(new int[]{10, 2}));
        System.out.println(minNumber(new int[]{3, 333, 3333333, 333333333, 33, 333333, 331}));
        System.out.println(minNumber(new int[]{20,1}));
        System.out.println(minNumber(new int[]{1,2,4,8,16,32,64,128,256,512}));

        // "1399439856075703697382482479389609"
        // "1399439856075703697382478249389609"
        System.out.println(minNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
        System.out.println(minNumber(new int[]{121, 12}));
    }

    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    static void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
