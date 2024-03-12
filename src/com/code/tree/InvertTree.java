package com.code.tree;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmpLeft = root.left;
        root.left = root.right;
        root.right = tmpLeft;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
