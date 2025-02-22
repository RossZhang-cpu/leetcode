package com.code.tree.binarytree;

import com.code.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        inOrderTraversal(root, queue, k);
        return queue.getLast();

    }

    private void inOrderTraversal(TreeNode root, Queue<Integer> queue, int k) {
        if (root == null)
            return;

        inOrderTraversal(root.left, queue, k);

        if (queue.size() == k) {
            return;
        }
        queue.offer(root.val);

        inOrderTraversal(root.right, queue, k);

    }
}
