package com.code.tree;

import java.util.*;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        bfs(list, queue1, 1);
        return list;
    }

    private void bfs(List<Integer> list, Queue<TreeNode> queue,int num) {
        if(num == 0)
            return;
        int number = 0;
        int right = 0;
        while (num > 0){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
                ++number;
            }
            if(node.right != null){
                queue.offer(node.right);
                ++number;
            }

            right = node.val;
            --num;
        }
        list.add(right);
        bfs(list, queue, number);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        node9.right = node10;
        node7.right = node9;
        node4.right = node7;
        node2.right = node4;
        node2.left = node5;
        node6.left = node8;
        node3.right = node6;
        node.left = node2;
        node.right = node3;
        List<Integer> integers = new RightSideView().rightSideView(node);
        System.out.println(integers.toString());
    }
}
