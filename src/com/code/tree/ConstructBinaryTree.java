package com.code.tree;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
 * is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 */

public class ConstructBinaryTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, postorder, 0, inorder.length, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end, int rootIdx) {
        if (start >= end)
            return null;

        int value = postorder[rootIdx];
        int nextRootIdx = start;
        for (; nextRootIdx < end; ++nextRootIdx) {
            if (inorder[nextRootIdx] == value) {
                break;
            }
        }
        int rightCount = end - nextRootIdx;
        //left  (0, rootIdx - right count)
        TreeNode left = build(inorder, postorder, start, nextRootIdx, rootIdx - rightCount);
        //right() (rootIdx - right count + 1, rootIdx)
        TreeNode right = build(inorder, postorder, nextRootIdx + 1, end, rootIdx - 1);

        TreeNode treeNode = new TreeNode(value);
        treeNode.left = left;
        treeNode.right = right;

        return treeNode;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};


        constructBinaryTree.buildTree(inorder, postOrder);
    }

    private static void test(int m) {
        --m;
//        System.out.println(m);
    }
}
