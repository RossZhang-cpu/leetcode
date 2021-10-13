package com.code.tree;

public class FindNext {

    public static TreeNode2 findNext(TreeNode2 root){
        if(root == null)
            return null;

        TreeNode2 next = null;
        if(root.right != null){
            next = root.right;
            while (next.left != null){
                next = next.left;
            }
            return next;
        }else if(root.parent != null){
            TreeNode2 current = root;
            TreeNode2 parent = root.parent;
            while (parent != null && current == parent.right)
                parent = parent.parent;

            next = parent;
        }
        return next;
    }
}
