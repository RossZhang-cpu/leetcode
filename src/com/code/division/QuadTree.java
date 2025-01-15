package com.code.division;


// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


public class QuadTree {
    public Node construct(int[][] grid) {
        int length = grid.length;

        Node root = constructNode(grid, 0, 0, length);
        return root;
    }

    private Node constructNode(int[][] grid, int i, int j, int length) {
        Node node = new Node();

        boolean isSameValue = isSameValue(grid, i, j, length);
        if (isSameValue) {
            node.val = grid[i][j] == 1;
            node.isLeaf = true;
        } else {
            node.isLeaf = false;
            node.val = true;
            int step = length / 2;

            Node topLeft = constructNode(grid, i, j, step);
            Node topRight = constructNode(grid, i, j + step, step);
            Node bottomLeft = constructNode(grid, i + step, j, step);
            Node bottomRight = constructNode(grid, i + step, j + step, step);

            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }
        return node;
    }

    private boolean isSameValue(int[][] grid, int i, int j, int length) {
        if (length <= 1) {
            return true;
        }

        boolean isSameValue = true;
        int temp = grid[i][j];
        for (int si = i; si < i + length; ++si) {
            for (int sj = j; sj < j + length; ++sj) {
                if (temp != grid[si][sj]) {
                    isSameValue = false;
                    break;
                }
            }
        }
        return isSameValue;
    }
}
