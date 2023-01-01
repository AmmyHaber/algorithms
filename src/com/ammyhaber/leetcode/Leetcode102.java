package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode102 {

    public static void main(String[] args) {
        System.out.println(levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(levelOrder(new TreeNode(1)));
        System.out.println(levelOrder(null));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> children = new ArrayList<>(2);
        if (root.left != null) {
            children.add(root.left);
        }
        if (root.right != null) {
            children.add(root.right);
        }
        res.add(List.of(root.val));
        bfs(children, res);
        return res;
    }

    private static void bfs(List<TreeNode> children, List<List<Integer>> res) {
        if (children == null || children.size() == 0) {
            return;
        }
        List<TreeNode> nextChildren = new ArrayList<>(children.size() * 2);
        List<Integer> vals = new ArrayList<>(children.size());
        for (TreeNode child : children) {
            vals.add(child.val);
            if (child.left != null) {
                nextChildren.add(child.left);
            }
            if (child.right != null) {
                nextChildren.add(child.right);
            }
        }
        res.add(vals);
        bfs(nextChildren, res);
    }
}
