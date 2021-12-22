package com.ammyhaber.leetcode;

/**
 * 226. 翻转二叉树
 */
public class Leetcode226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode invertTree = invertTree(root);
        System.out.println();
    }

    public static TreeNode invertTree(TreeNode root) {
        doInvertTree(root);
        return root;
    }

    private static void doInvertTree(TreeNode root) {
        if (root == null) {
            return;
        }
        doInvertTree(root.left);
        doInvertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
