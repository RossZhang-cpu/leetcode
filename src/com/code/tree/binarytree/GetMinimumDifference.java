package com.code.tree.binarytree;

import com.code.tree.TreeNode;

public class GetMinimumDifference {

    private int minimum = Integer.MAX_VALUE;
    private int previous = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        int i = inOrderTraversal(root);
        return i;


    }

    private int inOrderTraversal(TreeNode root) {
        if (root == null)
            return minimum;

        inOrderTraversal(root.left);

        minimum = Math.min(minimum, Math.abs(previous - root.val));
        previous = root.val;

        inOrderTraversal(root.right);

        return minimum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        GetMinimumDifference gmd = new GetMinimumDifference();
        int result = gmd.getMinimumDifference(root);
        System.out.println(result);



    }
}
