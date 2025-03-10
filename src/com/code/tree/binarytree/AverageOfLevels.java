package com.code.tree.binarytree;

import com.code.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            double average = 0;
            for (int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                average += node.val;
            }
            average /= size;
            list.add(average);
        }
        return list;
    }
}
