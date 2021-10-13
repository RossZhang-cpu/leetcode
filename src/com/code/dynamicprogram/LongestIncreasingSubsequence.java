package com.code.dynamicprogram;

public class LongestIncreasingSubsequence {

//    [10,9,2,5,3,7,101,18]
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxAns = 1;
        for (int i = 0; i < nums.length; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(dp[i], maxAns);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = new LongestIncreasingSubsequence().lengthOfLIS(nums);
        System.out.println(i);
    }
}
