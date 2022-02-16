package com.ammyhaber.leetcode;

import java.util.HashMap;

public class Leetcode437 {

    private static int count = 0;

    public static void main(String[] args) {
//        System.out.println(pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11))), 8));
        System.out.println(pathSum(new TreeNode(0, new TreeNode(1), new TreeNode(1)), 1));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        Integer sum = 0;
        dfs(root, targetSum, map, sum);
        return count;
    }

    private static void dfs(TreeNode root, int targetSum, HashMap<Integer, Integer> map, Integer sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (map.containsKey(sum - targetSum)) {
            count += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, targetSum, map, sum);
        dfs(root.right, targetSum, map, sum);
        map.put(sum, map.get(sum) - 1);
    }
}
