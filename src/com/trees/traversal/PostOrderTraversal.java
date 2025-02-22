package com.trees.traversal;

import com.trees.TreeNode;

public class PostOrderTraversal {

    public static void main(String[] args) {
        final TreeNode leaf1 = new TreeNode(3, null, null);
        final TreeNode leaf2 = new TreeNode(4, null, null);
        final TreeNode leaf3 = new TreeNode(7, null, null);
        final TreeNode leaf4 = new TreeNode(8, null, null);
        final TreeNode leftNode = new TreeNode(5, leaf1, leaf2);
        final TreeNode rightNode = new TreeNode(6, leaf3, leaf4);
        final TreeNode root = new TreeNode(1, leftNode, rightNode);
        performPostorderTraversal(root);
    }

    private static void performPostorderTraversal(final TreeNode root) {
        if (root == null) {
            return;
        }
        performPostorderTraversal(root.getLeft());
        performPostorderTraversal(root.getRight());
        System.out.print(root.getData() +" ");
    }
}
