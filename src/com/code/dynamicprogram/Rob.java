package com.code.dynamicprogram;

public class Rob {

    public int rob(int[] nums) {
        if (nums.length  == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; ++i) {
            int before3 = Math.max(i - 3, 0);
            dp[i] = Math.max(dp[i - 2], dp[before3]) + nums[i];
        }

        return Math.max(dp[n - 1], dp[n - 2]);

    }

}
