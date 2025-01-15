package com.code.matrix;

public class LifeOfGame {

    public void gameOfLife(int[][] board) {
        int len0 = board.length;
        int len1 = board[0].length;
        int[][] marks = new int[len0][len1];

        for (int i = 0; i < len0; ++i) {
            for (int j = 0; j < len1; ++j) {
                marks[i][j] = countLiveCells(board, i, j);
            }
        }


        for (int i = 0; i < len0; ++i) {
            for (int j = 0; j < len1; ++j) {
                if (board[i][j] == 0) {
                    if (marks[i][j] == 3)
                        board[i][j] = 1;
                } else {
                    if (marks[i][j] < 2 || marks[i][j] > 3)
                        board[i][j] = 0;
                }
            }
        }


    }

    public int countLiveCells(int[][] board, int i, int j) {
        int liveCount = 0;
        for (int si = i - 1; si <= i + 1; ++si) {
            for (int sj = j - 1; sj <= j + 1; ++sj) {
                if (si >= 0 && si < board.length && sj >= 0
                        && sj < board[0].length) {
                    liveCount += board[si][sj];
                }
            }
        }
        liveCount -= board[i][j];
        return liveCount;
    }

    public static void main(String[] args) {
        int[][] num = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        LifeOfGame lifeOfGame = new LifeOfGame();
        lifeOfGame.gameOfLife(num);
    }
}
