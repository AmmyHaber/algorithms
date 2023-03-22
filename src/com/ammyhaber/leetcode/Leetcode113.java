package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode113 {

    public static void main(String[] args) {
        List<List<Integer>> lists = pathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))), 22);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        recursive(root, results, targetSum, 0, new ArrayList<>());
        return results;
    }

    private static void recursive(TreeNode root, List<List<Integer>> results, int targetSum, int sum, ArrayList<Integer> paths) {
        paths.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null) {
            // 叶子节点
            if (sum == targetSum) {
                results.add(paths);
            } else {
                return;
            }
        }
        int size = paths.size();
        if (root.left != null) {
            recursive(root.left, results, targetSum, sum, new ArrayList<>(paths));
        }
        if (root.right != null) {
            recursive(root.right, results, targetSum, sum, new ArrayList<>(paths));
        }
    }
}
