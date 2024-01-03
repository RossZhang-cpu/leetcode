package com.code.tree;

import java.util.LinkedList;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> left = new LinkedList<>();
        LinkedList<TreeNode> right = new LinkedList<>();
        left.push(root.left);
        right.push(root.right);
        // mirror of root. left tree is normal order, right tree is opposite order.
        boolean flag = true;
        while (left.size() > 0 && right.size() > 0){
            TreeNode leftNode = left.pop();
            TreeNode rightNode = right.pop();
            if (leftNode == null && rightNode == null){
                continue;
            }else if (leftNode != null && rightNode != null && leftNode.val == rightNode.val){
                left.push(leftNode.left);
                left.push(leftNode.right);
                right.push(rightNode.right);
                right.push(rightNode.left);
            }else {
                flag = false;
                break;
            }


        }
        return flag;
    }
}
