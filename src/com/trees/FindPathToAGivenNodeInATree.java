package com.trees;

import java.util.ArrayList;

/**
 * Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.
 * NOTE: No two nodes in the tree have the same data values AND You can assume that B is present in tree A and a path always exists.
 */
public class FindPathToAGivenNodeInATree {
    public static void main(String[] args) {
        final TreeNode leaf1 = new TreeNode(3, null, null);
        final TreeNode leaf2 = new TreeNode(4, null, null);
        final TreeNode leaf3 = new TreeNode(7, null, null);
        final TreeNode leaf4 = new TreeNode(8, null, null);

        final TreeNode leftNodeFirst = new TreeNode(5, leaf1, leaf2);
        final TreeNode rightNodeFirst = new TreeNode(6, leaf3, leaf4);
        final TreeNode rootFirst = new TreeNode(1, leftNodeFirst, rightNodeFirst);

        System.out.println("GET PATH TO A NODE IN A BINARY TREE "+ getPathToANode(rootFirst, 4));
        System.out.println("GET PATH TO A NODE IN A BINARY TREE "+ getPathToANode(rootFirst, 7));
    }

    private static ArrayList<Integer> getPathToANode(TreeNode A, int B) {
        final ArrayList<Integer> path = new ArrayList<>();
        searchValue(A, B, path);
        return path;
    }

    private static boolean searchValue(final TreeNode root, final int B, final ArrayList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.getData());
        if (root.getData() == B || searchValue(root.getLeft(), B, list) || searchValue(root.getRight(), B, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
}
