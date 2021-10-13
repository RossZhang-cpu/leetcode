package com.code.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];

        for(int i = 0; i < board.length; ++i){
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] != '.'){
                    int num = (int)board[i][j];
                    int box_index = ( i / 3) * 3 + j / 3;
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[box_index].put(num, boxes[i].getOrDefault(num, 0) + 1);

                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[box_index].get(num) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    private void subValid(int i, int j, char[][] board, int[] depu) {

    }

    public static void main(String[] args) {
       double result  = 21.7 + 36.8 + 16.5 + 8.5 + 35.5 + 23.5 + 36.7 + 10.9 + 16.3 + 17.5 + 19.1 + 11.1 + 12.9
                + 17.3 + 47 + 10.9 + 20.5 + 9.1 + 12.5 + 30.6 + 10.9 + 41.8 + 19.5 + 8.5 + 8.5 + 9.5 + 9.5 + 32.1 + 9.3 + 14.9 + 11.1 + 21.7 + 21.1;
        double v = 109.64 + 78.96 + 81.89 + 600;
        double i = v + result ;
        System.out.println(v);
        System.out.println("sum:" + i);
    }


}
