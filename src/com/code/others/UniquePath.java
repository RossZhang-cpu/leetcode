package com.code.others;

public class UniquePath {


    public int uniquePaths(int m, int n) {
        //f[i, j] = f(i - 1, j) + f (i, j - 1);
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i){
            dp[i][0] = 1;
        }
        for (int j = 1 ; j < n; ++j){
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; ++i){
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int j = 0; j < obstacleGrid[0].length; ++j){
            //no obstacle
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            }else {
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; ++i){
            for (int j = 1; j < obstacleGrid[0].length; ++j){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacle = {{0,0,0},{0,1,0},{0,0,0}};
        UniquePath uniquePath = new UniquePath();
        int i = uniquePath.uniquePathsWithObstacles(obstacle);
        System.out.println(i);
    }
}
