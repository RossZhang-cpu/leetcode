package com.code.tree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        return dfs(root, sum, targetSum);
    }

    private boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;

        if (root.right == null && root.left == null) {
            return targetSum == sum;
        }

        boolean flag = dfs(root.left, sum, targetSum);
        if (flag) {
            return flag;
        } else {
             flag = dfs(root.right, sum, targetSum);
             return flag;
        }

    }

}
