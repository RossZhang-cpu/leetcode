package com.code.others;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int  i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                if (matrix[i][j] == '1'){
                    //探测右下方
                    int tempArea = maxSquareArea(i, j, 1, matrix);
                    max = Math.max(max, tempArea);
                }
            }
        }
        return max;
    }

    private int maxSquareArea(int i, int j, int side, char[][] matrix) {
        for (int m = 0; m < side + 1; ++m){
            if ((i + side) >= matrix.length || (j + m) >= matrix[0].length || matrix[i + side][j + m] == '0'){
                return side * side;
            }
        }
        for(int n = 0; n < side + 1; ++n){
            if ((i + n) >= matrix.length || (j + side) >= matrix[0].length || matrix[i + n][j + side] == '0'){
                return side * side;
            }
        }
        return maxSquareArea(i, j, ++side, matrix);
    }

}
