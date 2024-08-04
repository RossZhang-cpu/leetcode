package com.code.tree.selfbalance;


import com.code.tree.TreeNode;

import static com.code.tree.selfbalance.RedBlackNode.*;

/**
 * - Each node is colored either red or black.
 * - The root of the tree is always black.
 * - Red nodes cannot have red children (no two red nodes can be adjacent).
 * - Every path from a node to its descendant leaves must have the same number of black nodes (black height).
 * <p>
 *
 * - All leaves (NIL or sentinel nodes) are considered black.
 */
public class RedBlackTree {


    public static void main(String[] args) {

    }

    public void prettyPrint(RedBlackNode root){

    }

    public RedBlackNode insert(TreeNode node, RedBlackNode root) {
        RedBlackNode currentNode = performBSTInsertion(node, root);
        fixToRedBlack(currentNode, root);
        return root;
    }

    private void fixToRedBlack(RedBlackNode currentNode, RedBlackNode root) {
        if(currentNode == root) {
            System.out.println("currentNode is root, change color to black");
            currentNode.color = BLACK;
            return;
        }
        RedBlackNode parent = currentNode.parent;
        if (parent.color == RED) {
            RedBlackNode uncle = findUncle(currentNode);
            if (uncle == null) {
                //same when uncle is black
            } else if (uncle.color == RED) {
                fixWhenUncleIsRed(uncle, parent, root);
            } else {
                fixUncleIsBlack(currentNode, uncle, parent, root);
            }
        }
        //black or root(black) return
    }

    private void fixUncleIsBlack(RedBlackNode currentNode, RedBlackNode uncle, RedBlackNode parent, RedBlackNode root) {
        //TODO:
        RedBlackNode middleNode;
        if (parent.val < parent.parent.val) {

        }


        //
    }

    private void fixWhenUncleIsRed(RedBlackNode uncle, RedBlackNode parent, RedBlackNode root) {
        uncle.color = BLACK;
        parent.color = BLACK;
        parent.parent.color = RED;
        fixToRedBlack(parent.parent, root);
    }

    private RedBlackNode findUncle(RedBlackNode currentNode) {
        RedBlackNode parent = currentNode.parent;
        RedBlackNode grandParent = parent.parent;
        return grandParent.left == parent ? grandParent.right : grandParent.left;
    }

    private RedBlackNode performBSTInsertion(TreeNode node, RedBlackNode root) {
        RedBlackNode newNode = createRedNode(node.val);
        if (root == null) {
            root = newNode;
            return newNode;
        }

        RedBlackNode rbNode = root;
        RedBlackNode parent = root;
        Boolean addLeft = null;
        while (rbNode != null) {
            parent = rbNode;
            if (newNode.getVal() > rbNode.getVal()) {
                rbNode = rbNode.getRight();
                addLeft = false;
            } else if (newNode.getVal() < rbNode.getVal()) {
                rbNode = rbNode.getLeft();
                addLeft = true;
            } else {
                addLeft = null;
                break;
            }
        }

        if (addLeft == null) {
            System.out.println("not allowed duplicate values");
        }else if (addLeft) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        return newNode;
    }
}
