package com.code.others;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length; ++i){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; ++i){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; ++i){
            for (int j = 1; j < grid[0].length; ++j){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        double s = 8.5 + 20.5 + 19.5 + 31.7 + 35.8 + 16.3 + 10.5 + 8.5;
        double s1 =  10.9 + 17.1 + 23.7 + 26.1 + 18.1 + 18.5 + 14.6 + 8.5;
        double s2 = 8.5 + 8.5 + 11.7 + 13.9 + 11.5 + 12.7 + 17.7 + 11.5 + 16.3 + 12.9 + 9.5 + 16.4;
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 + s + s2);
        double f = 106.27 + 125.69 + 832.08;
        System.out.println(f);
        System.out.println(s1 + s + s2 + f);
    }

}
