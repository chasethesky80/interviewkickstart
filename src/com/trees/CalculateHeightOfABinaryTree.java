package com.trees;

public class CalculateHeightOfABinaryTree {

    public static void main(String[] args) {
        final TreeNode leaf1 = new TreeNode(3, null, null);
        final TreeNode leaf2 = new TreeNode(4, null, null);
        final TreeNode leaf3 = new TreeNode(7, null, null);
        final TreeNode leaf4 = new TreeNode(8, null, null);
        final TreeNode leftNode = new TreeNode(5, leaf1, leaf2);
        final TreeNode rightNode = new TreeNode(6, leaf3, leaf4);
        final TreeNode root = new TreeNode(1, leftNode, rightNode);
        System.out.println("HEIGHT OF TREE "+ height(root));
    }

    /**
     * Time complexity of a binary tree is O(N) since we have to travel all nodes of the tree and space complexity
     * is also O(N) since the size of the call stack is O(N) as we have to compute height of all nodes of the tree
     * during its traversal
     * NOTE: WE USE THE POST-ORDER TRAVERSAL TO FIND THE HEIGHT OF A TREE
     * @param root
     * @return
     */
    private static int height(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }
}
