package com.code.recursion;

import com.code.tree.TreeNode;

public class FlattenBiTree {
    /*114. 二叉树展开为链表
    给定一个二叉树，原地将它展开为一个单链表
    1
   / \
  2   5
 / \   \
3   4   6


 1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6 */
    public void flatten(TreeNode root) {
        recursion(root);
    }

    public void recursion(TreeNode root){
        if(root == null) return ;

        recursion(root.left);
        recursion(root.right);
        if(root.left != null ){
            TreeNode rightnode = root.right;
            TreeNode leftnode = root.left;
            while (leftnode.right != null){
                leftnode = leftnode.right;
            }
            leftnode.right = rightnode;
            root.right = root.left;
            root.left = null;
        }
    }
}
