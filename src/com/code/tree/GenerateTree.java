package com.code.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateTree {

    public List<TreeNode> generateTrees(int n) {
      if(n == 0) return new LinkedList<TreeNode>();
      var list = rebuildTree(1, n);
      System.out.println(list.size());
      return rebuildTree(1, n);
    }

    public List rebuildTree(int s, int e){
        var list = new LinkedList<TreeNode>();
        if(s < 0 || s > e ) {
            list.add(null);
            return list;
        }

        for(int i = s; i <= e; ++i) {
            List<TreeNode> left = rebuildTree(s, i - 1);
            List<TreeNode> right = rebuildTree(i + 1, e);

            for(TreeNode leftnode : left){
                for(TreeNode rightnode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public int numTrees(int n) {
        if(n < 1) return 0;
        if(n == 1) return 1;

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; ++i){
          int result  = 0;
          for(int j = 1; j <= i; ++j){
             result += dp[j - 1] * dp[i - j];
          }
            dp[i] = result;
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new GenerateTree().numTrees(3));
    }
}
