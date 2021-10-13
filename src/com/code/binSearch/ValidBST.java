package com.code.binSearch;

import com.code.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    private boolean flag = true;
    private List<Integer> values = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if (root == null || !flag)
            return;

        dfs(root.left);
        if (values.isEmpty() || root.val > values.get(values.size() - 1)){
            values.add(root.val);
        }else {
            flag = false;
            return;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node10 = new TreeNode(10);

        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;

        ValidBST validBST = new ValidBST();
        boolean validBST1 = validBST.isValidBST(node5);
        System.out.println(validBST1);
    }
}
