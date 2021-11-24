package com.ammyhaber.leetcode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Leetcode101 {

    public static void main(String[] args) {
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric2(root.left, root.right);
    }

    private static boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left!= null && right != null && left.val == right.val && isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left)) {
            return true;
        }
        if (left == null && right == null) {
            return true;
        }
        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
