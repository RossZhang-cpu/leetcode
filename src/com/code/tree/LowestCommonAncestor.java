package com.code.tree;

public class LowestCommonAncestor {
    /**

    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and q as
    the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
    **/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        TreeNode left = p;
        TreeNode right = q;

        if (p.val > q.val) {
            left = q;
            right = p;
        }

        return findLST(root, left, right);





    }

    private TreeNode findLST(TreeNode root, TreeNode left, TreeNode right) {
        // left < right
        TreeNode node = root;
        if (left.val <= node.val && right.val >= node.val) {
            return node;
        } else if (left.val <= node.val && right.val < node.val) {
            node = root.left;
            node = findLST(node, left, right);
        } else {
            node = root.right;
            node = findLST(node, left, right);
        }
        return node;
    }
}
