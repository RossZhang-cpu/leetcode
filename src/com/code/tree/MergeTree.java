package com.code.tree;

public class MergeTree {

    //对于树尝试用递归思路
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null ) return t2;
        if(t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t1.right);
        return t1;
    }
}
