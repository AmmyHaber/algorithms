package com.ammyhaber.leetcode;

public class Leetcode106 {

    public static void main(String[] args) {
        TreeNode head = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println();
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuild(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode doBuild(int[] inorder, int inFrom, int inTo, int[] postorder, int postFrom, int postTo) {
        if (inTo < inFrom || postTo < postFrom) {
            return null;
        }
        if (inTo == inFrom || postFrom == postTo) {
            return new TreeNode(inorder[inFrom]);
        }
        int headVal = postorder[postTo];
        int headIndex = findHeadIndex(inorder, inFrom, inTo, headVal);
        int leftSize = headIndex - inFrom;
        int rightSize = inTo - headIndex;
        TreeNode head = new TreeNode(headVal);
        head.left = doBuild(inorder, inFrom, headIndex - 1, postorder, postFrom, postFrom + leftSize - 1);
        head.right = doBuild(inorder, headIndex + 1, inTo, postorder, postTo - rightSize, postTo - 1);
        return head;
    }

    private static int findHeadIndex(int[] inorder, int inFrom, int inTo, int headVal) {
        for (int i = inFrom; i <= inTo; i++) {
            if (inorder[i] == headVal) {
                return i;
            }
        }
        return 0;
    }
}
