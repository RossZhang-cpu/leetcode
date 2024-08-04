package com.code.dynamicprogram;

public class CombinationSum {

    public void combinationSum4() {

    }

    public int coinChange(int[] coins, int amount) {
        //比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
        /*
        dp(n): 凑出面值n最少需要的数量

        dp(0) = 0
        dp(1) =

        dp(11) = min(1 + dp(11 - 5), 1 + dp(11-2), dp(1) + dp(11 -1))
        dp(n) = min(i in nums dp(i) + dp(n - i)

         ***/

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    int tmp = 1 + dp[i - coin];
                    dp[i] = Math.min(tmp, dp[i]);
                }
            }
        }
        return dp[amount];

    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int i = combinationSum.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);

    }
}
