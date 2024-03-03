package com.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevels {

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = false;
        ArrayList<TreeNode> arr = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                if (isOdd) {
                    arr.add(node);
                }
            }
            for (int i = 0, j = arr.size() - 1; i < j; ++i, --j) {
                TreeNode left = arr.get(i);
                TreeNode right = arr.get(j);
                int tmp = left.val;
                left.val = right.val;
                right.val = tmp;
            }
            arr.clear();
            isOdd ^= true;
        }
        return root;

    }


    /**
     * solution2 dfs
     * @param root
     * @return
     */
    public TreeNode reverseOddLevels2(TreeNode root) {
        if (root == null) {
            return root;
        }
        boolean isOdd = false;
        dfs(root.left, root.right, !isOdd);
        return root;

    }

    private void dfs(TreeNode left, TreeNode right, boolean isOdd) {
        if (left == null) {
            return ;
        }
        if (isOdd) {
            int val = left.val;
            left.val = right.val;
            right.val = val;
        }
        dfs(left.left,  right.right, !isOdd);
        dfs(left.right, right.left, !isOdd);
    }
}
