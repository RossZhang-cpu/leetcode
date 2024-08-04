package com.code.tree.selfbalance;

public class RedBlackNode {
    int val;
    RedBlackNode left;
    RedBlackNode right;

    RedBlackNode parent;
    boolean color;

    final static boolean RED = true;
    final static boolean BLACK = false;

    public RedBlackNode(int val, boolean color) {
        this.val = val;
        this.color = color;
    }

    public RedBlackNode(int val, RedBlackNode left, RedBlackNode right, RedBlackNode parent, boolean color) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.color = color;
        this.parent = parent;
    }

    public static RedBlackNode createRedNode(int val) {
        return new RedBlackNode(val, RED);
    }

    public static RedBlackNode createBlackNode(int val) {
        return new RedBlackNode(val, BLACK);
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public RedBlackNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
