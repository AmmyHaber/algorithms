package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{0, 1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, result, new ArrayList<>());
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, ArrayList<Integer> group) {
        if (group.size() == nums.length) {
            result.add(new ArrayList<>(group));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (group.contains(nums[i])) {
                continue;
            }
            group.add(nums[i]);
            dfs(nums, result, group);
            group.remove(group.size() - 1);
        }
    }
}
