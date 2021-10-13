package com.code.dynamicprogram;

import java.util.Arrays;

public class MaxSubArray {

//    输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//    要求时间复杂度为O(n)。
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];

       for(int i = 1; i < nums.length; ++i){
           dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
           max = Math.max(dp[i], max);
       }
       return max;
    }

    //给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
    //coins = [1, 2, 5], amount = 11
    public int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for(int i =  1; i <  dp.length; ++i){
            for (int j = 0; j < coins.length && j < i; ++j) {
               if(i - coins[j]>= 0 && dp[i - coins[j]] != -1){
                   if(dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1)
                       dp[i] = dp[i - coins[j]] + 1;
               }
            }
        }
        return  dp[amount];
        }
    }


