package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {

    private static List<Integer> group = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        return doSum(candidates, 0, target, result);
    }

    private static List<List<Integer>> doSum(int[] candidates, int index, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(group));
            return result;
        }
        if (target < 0) {
            return result;
        }
        for (int i = index; i < candidates.length; i++) {
            group.add(candidates[i]);
            doSum(candidates, i, target - candidates[i], result);
            group.remove(group.size() - 1);
        }
        return result;
    }
}
