package com.code.tree;


public class ConvertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            TreeNode node = convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);
        }
        return root;
    }


    private TreeNode dfs(TreeNode node, int i) {
        if (node == null)
            return node;

        TreeNode rightNode = dfs(node.right, i);
        //拷贝
        TreeNode result = new TreeNode(node.val);
        if (rightNode != null){
            result.right = new TreeNode(rightNode.val, rightNode.left, rightNode.right);
            result.val += i;
        }
        i = result.val;
        TreeNode leftNode = dfs(node.left, i);
        if (leftNode != null){
            result.left = new TreeNode(leftNode.val, leftNode.left, leftNode.right);
            result.val += i;
        }
        return node;
    }
}
