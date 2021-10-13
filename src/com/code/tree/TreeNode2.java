package com.code.tree;

/*
* 带有指向父结点的节点
 */
public class TreeNode2<T> {
    T val;
    TreeNode2<T> left;
    TreeNode2<T> right;
    TreeNode2<T>  parent;

    public TreeNode2(T val, TreeNode2<T> left, TreeNode2<T> right, TreeNode2<T> parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode2(){
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode2<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode2<T> left) {
        this.left = left;
    }

    public TreeNode2<T> getRight() {
        return right;
    }

    public void setRight(TreeNode2<T> right) {
        this.right = right;
    }

    public TreeNode2<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode2<T> parent) {
        this.parent = parent;
    }
}
