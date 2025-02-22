package com.trees;

public class CheckIfTwoBinaryTreesAreMirrorImages {

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

        final TreeNode rootFourth = new TreeNode(1, rightNodeSecond, leftNodeSecond);
        System.out.println("ARE BINARY TREES IDENTICAL "+ areMirrorImages(rootFirst, rootSecond));
        System.out.println("ARE BINARY TREES IDENTICAL "+ areMirrorImages(rootSecond, rootFirst));
        System.out.println("ARE BINARY TREES IDENTICAL "+ areMirrorImages(rootFirst, rootThird));
        System.out.println("ARE BINARY TREES IDENTICAL "+ areMirrorImages(rootSecond, rootFourth));
    }

    private static boolean areMirrorImages(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.getData() != root2.getData()) {
            return false;
        }
        if (!areMirrorImages(root1.getLeft(), root2.getRight())) {
            return false;
        }
        return areMirrorImages(root1.getRight(), root2.getLeft());
    }
}
