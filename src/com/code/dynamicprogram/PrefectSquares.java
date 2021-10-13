package com.code.dynamicprogram;

public class PrefectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i < n+1; ++i){
            int sqrt = (int) Math.sqrt(i);
            if(sqrt * sqrt == i){     //为可整除开放的
                dp[i] = 1;
            }else{
                computeNumber(dp, i);
            }
        }
        return dp[n];
    }

    private void computeNumber(int[] dp, int num) {
        int min = Integer.MAX_VALUE;
        for(int i = 1, j = (num - 1); i <= j; ++i, -- j){
            min = Math.min(min, dp[i] + dp[j]);
        }
        dp[num] = min;
    }

    public static void main(String[] args) {
        PrefectSquares prefectSquares = new PrefectSquares();
        int i = prefectSquares.numSquares(3);
        int j = prefectSquares.numSquares(13);
        System.out.println("i :" + i);
        System.out.println("j :" + j);
    }
}
