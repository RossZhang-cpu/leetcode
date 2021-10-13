package com.code.tree;

import java.util.HashMap;
import java.util.Map;

public class ReBuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || preorder.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; ++i){
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map );
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,  Map<Integer, Integer> map ){
        if(preStart > preEnd)
            return null;

        if (preStart == preEnd){        //无子节点
            TreeNode root = new TreeNode(preorder[preStart]);  //根节点的值
            root.left = null;
            root.right = null;
            return root;
        }else{      //存在子节点
            TreeNode root = new TreeNode(preorder[preStart]);
            Integer rootIndex = map.get(preorder[preStart]);  //根节点在中序中的下标
            int leftnodes = rootIndex - inStart;    //左子树的个数
            root.left = buildTree(preorder, preStart + 1, preStart + leftnodes, inorder, rootIndex - leftnodes, rootIndex -1 , map);
            root.right = buildTree(preorder, preStart + leftnodes + 1, preEnd,
                    inorder, rootIndex + 1, inEnd, map );
//            root.right = buildTree(preorder, preStart + leftnodes + 1, preorder.length - 1, inorder, rootIndex + 1, inorder.length - 1, map);
            return root;
        }
    }
}
