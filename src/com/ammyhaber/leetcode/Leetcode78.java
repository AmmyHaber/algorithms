package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
