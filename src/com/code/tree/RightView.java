package com.code.tree;

import java.util.ArrayList;
import java.util.List;

public class RightView {

    private int max = 0;

    public List<Integer> rightSideView(TreeNode root){
        if(root == null)
            return null;
        List<Integer> result = new ArrayList<>();
        dfs(root, 1, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (root == null)
            return;
        if (depth > max){
            result.add(root.val);
            max = depth;
        }
        dfs(root.right, depth+1, result);
        dfs(root.left, depth+1, result);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        node9.right = node10;
        node7.right = node9;
        node4.right = node7;
        node2.right = node4;
        node2.left = node5;
        node6.left = node8;
        node3.right = node6;
        node.left = node2;
        node.right = node3;
        List<Integer> integers = new RightView().rightSideView(node);
        System.out.println(integers.toString());
    }
}
