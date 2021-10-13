package com.code.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTravelSal {

    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List list){
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
