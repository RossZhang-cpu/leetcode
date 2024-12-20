package com.code.array;

/**
 * https://leetcode.cn/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150
 */
public class XArea {

    public void solve(char[][] board) {
        //search from corner side
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (j != 0 && j != board[0].length - 1 && i != 0 && i != board.length - 1) {
                    continue;
                }

                if (board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] != 'O'){
            return;
        }
        // board is 0
        board[i][j] = 'A';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);

    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'}, {'X','O','X','X'}};
        XArea xArea = new XArea();
        xArea.solve(board);

    }
}
