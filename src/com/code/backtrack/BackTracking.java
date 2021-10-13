package com.code.backtrack;

import java.sql.Struct;
import java.util.Arrays;
/*
*   回溯法求解
*
 */
public class BackTracking {
    public boolean backTracking(char[][] matrix,  String str){
        if(matrix == null && matrix.length == 0)
            return false;

        char[] chars = str.toCharArray();
        int rows = matrix.length; int cols = matrix[0].length;
        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(hasPathCore(matrix, i, j, rows, cols, chars, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[][] matrix, int i, int j, int rows, int cols, char[] chars, int pathlength, boolean[] visited){
        if(chars == null && chars.length == 0)
            return true;

        boolean haspath = false;
        if(i >= 0 && i < rows && j >= 0  && j < cols && matrix[i][j] == chars[pathlength]
                && pathlength < chars.length && !visited[i * cols + j]  )
        {
            visited[i * cols + j] = true;  //当前已访问
            ++pathlength; //遍历下一个元素
            haspath = hasPathCore(matrix, i-1, j, rows, cols, chars, pathlength, visited) ||
                      hasPathCore(matrix, i+1, j, rows, cols, chars, pathlength, visited) ||
                      hasPathCore(matrix, i, j-1, rows, cols, chars, pathlength, visited) ||
                      hasPathCore(matrix, i, j+1, rows, cols, chars, pathlength, visited);

            if(!haspath){   //访问都不成功, 回退
                --pathlength;
                visited[i * cols + j] = false;
            }
        }
        return haspath;
    }
}
