package com.code.tree;

import java.util.HashMap;
import java.util.Map;

public class Rob {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);

        int robroot = root.val + ((root.left == null) ? 0 : rob(root.left.left)) + ((root.left == null) ? 0 :rob(root.left.right)) +
                ((root.right == null) ? 0 : rob(root.right.left)) +((root.right == null) ? 0:rob(root.right.right));
        int unrobroot =  rob(root.left) + rob(root.right);
        int max = Math.max(robroot, unrobroot);
        memo.put(root, max);
        return max;
    }
}
