package com.ammyhaber.leetcode;

public class Leetcode337 {

    public static void main(String[] args) {
        System.out.println(rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
        System.out.println(rob(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)))));
        System.out.println(rob(new TreeNode(4, new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))), null)));
    }

    public static int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftResult = dfs(root.left);
        int[] rightResult = dfs(root.right);
        int[] result = new int[2];
        result[0] = leftResult[1] + rightResult[1] + root.val;
        result[1] = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
        return result;
    }
}
