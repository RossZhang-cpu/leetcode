package com.code.tree.binarytree;

import com.code.tree.TreeNode;

/**
 * https://leetcode.cn/problems/count-complete-tree-nodes/?envType=study-plan-v2&envId=top-interview-150
 */
public class CountNodes {

    private int height = 0;
    private int lastNode = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);
        int sum = 0;
        for (int i = 0; i < height - 1; ++i) {
            sum += (int) Math.pow(2, i);
        }
        return sum + lastNode;

    }

    private boolean dfs(TreeNode node, int i) {
        if (node == null) {
            if (i - 1 > height) {
                height = i - 1;
            } else if (i - 1 < height) {
                return true;
            }
            return false ;
        }
        boolean isEnd = dfs(node.left, i + 1) || dfs(node.right, i + 1);
        if (i == height) {
            ++lastNode;
        }

        return isEnd;

    }
}
