package com.code.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/binary-search-tree-iterator/
 */
public class BSTIterator {

    private final Deque<TreeNode> stack = new LinkedList<>();

    private TreeNode cur;


    public BSTIterator(TreeNode root) {
        stack.push(root);
        cur = root;
    }

    public int next() {
        TreeNode node = cur;
        while (node != null && node.left != null) {
            node = node.left;
            stack.push(node);
        }

        cur = stack.pop();
        int res = cur.val;
        if (cur.right != null) {
            stack.push(cur.right);
            cur = cur.right;
        } else {
            cur = null;
        }

        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
