package com.trees;

/**
 * GIVEN 2 BINARY TREES OF NODES N AND M, CHECK IF THE 2 BINARY TREES ARE IDENTICAL
 */
public class CheckIfTwoBinaryTreesAreIdentical {

    public static void main(String[] args) {
        final TreeNode leaf1 = new TreeNode(3, null, null);
        final TreeNode leaf2 = new TreeNode(4, null, null);
        final TreeNode leaf3 = new TreeNode(7, null, null);
        final TreeNode leaf4 = new TreeNode(8, null, null);

        final TreeNode leftNodeFirst = new TreeNode(5, leaf1, leaf2);
        final TreeNode rightNodeFirst = new TreeNode(6, leaf3, leaf4);
        final TreeNode rootFirst = new TreeNode(1, leftNodeFirst, rightNodeFirst);

        final TreeNode leftNodeSecond = new TreeNode(5, leaf1, leaf2);
        final TreeNode rightNodeSecond = new TreeNode(6, leaf3, leaf4);
        final TreeNode rootSecond = new TreeNode(1, leftNodeSecond, rightNodeSecond);

        final TreeNode leaf5 = new TreeNode(13, null, null);
        final TreeNode leftNodeThird = new TreeNode(5, leaf5, leaf2);
        final TreeNode rightNodeThird = new TreeNode(6, leaf3, leaf4);
        final TreeNode rootThird = new TreeNode(1, leftNodeThird, rightNodeThird);

        System.out.println("ARE BINARY TREES IDENTICAL "+ areIdenticalTrees(rootFirst, rootSecond));
        System.out.println("ARE BINARY TREES IDENTICAL "+ areIdenticalTrees(rootSecond, rootFirst));
        System.out.println("ARE BINARY TREES IDENTICAL "+ areIdenticalTrees(rootFirst, rootThird));
    }

    /**
     * TC = O(Min(N,M)) WHERE N AND M ARE THE NUMBER OF NODES IN THE 2 BINARY TREES
     * @param root1
     * @param root2
     * @return
     */
    private static boolean areIdenticalTrees(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.getData() != root2.getData()) {
            return false;
        }
        if (!areIdenticalTrees(root1.getLeft(), root2.getLeft())) {
            return false;
        }
        return areIdenticalTrees(root1.getRight(), root2.getRight());
    }
}
