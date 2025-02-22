package com.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return List.of();

        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        stack1.push(root);
        LinkedList<TreeNode> cur = stack1;
        boolean isReverseLevel = false;
        while (!cur.isEmpty()) {
            int size = cur.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();
            LinkedList<TreeNode> next = cur == stack1 ? stack2 : stack1;
            for (int i = 0; i < size; ++i) {
                TreeNode node = cur.pop();
                if (node == null) continue;
                levelNodes.add(node.val);
                if (isReverseLevel) {
                    next.push(node.right);
                    next.push(node.left);
                } else {
                    next.push(node.left);
                    next.push(node.right);
                }
            }
            isReverseLevel = !isReverseLevel;
            cur = next;
            if (!levelNodes.isEmpty()) {
                list.add(levelNodes);
            }
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
