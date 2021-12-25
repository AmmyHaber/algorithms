package com.ammyhaber.leetcode;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 */
public class Leetcode617 {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode tree2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode mergedTree = mergeTrees(tree1, tree2);
        System.out.println();
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return doMerge(root1, root2);
    }

    private static TreeNode doMerge(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergedLeft = doMerge(root1.left, root2.left);
        TreeNode mergedRight = doMerge(root1.right, root2.right);
        root1.val = root1.val + root2.val;
        root1.left = mergedLeft;
        root1.right = mergedRight;
        root2.left = null;
        root2.right = null;
        return root1;
    }
}
