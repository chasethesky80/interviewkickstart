package com.trees;

/**
 * SEARCH FOR A GIVEN VALUE IN A BINARY TREE
 */
public class SearchForAValueInABinaryTree {

    public static void main(String[] args) {
        final TreeNode leaf1 = new TreeNode(3, null, null);
        final TreeNode leaf2 = new TreeNode(4, null, null);
        final TreeNode leaf3 = new TreeNode(7, null, null);
        final TreeNode leaf4 = new TreeNode(8, null, null);
        final TreeNode leftNode = new TreeNode(5, leaf1, leaf2);
        final TreeNode rightNode = new TreeNode(6, leaf3, leaf4);
        final TreeNode root = new TreeNode(1, leftNode, rightNode);
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, 3));
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, 1));
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, 10));
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, 7));
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, 8));
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, 13));
        System.out.println("DOES NUMBER EXIST "+ searchValue(root, -1));
    }

    private static boolean searchValue(final TreeNode root, final int K) {
        if (root == null) {
            return false;
        }
        if (root.getData() == K || searchValue(root.getLeft(), K)) {
            return true;
        }
        return searchValue(root.getRight(), K);
    }
}
