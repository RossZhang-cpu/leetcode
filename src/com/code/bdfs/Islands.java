package com.code.bdfs;

public class Islands {

    public int numIslands(char[][] grid) {
        int number = 0;

        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j <grid[0].length; ++j){
                if(grid[i][j] == '1'){
                    ++number;
                    dfs(grid, i, j);
                }
            }
        }
        return number;

    }

    private void dfs(char[][] grid, int i, int j) {
        if(j >= grid[0].length || i >= grid.length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
    }

}
