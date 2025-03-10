package com.code.tree;

/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SumRootToLeafNumbers {

    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int num) {
        if (node == null) {
            return;
        }

        num = node.val + num * 10;
        if (node.right == null && node.left == null) {
            sum +=num;
            return;
        }
        dfs(node.left, num);
        dfs(node.right, num);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumRootToLeafNumbers leafNumbers = new SumRootToLeafNumbers();
        int i = leafNumbers.sumNumbers(root);
        System.out.println(i);
    }
}
