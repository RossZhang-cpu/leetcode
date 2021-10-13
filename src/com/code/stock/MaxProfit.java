package com.code.stock;

public class MaxProfit {
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//    如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    public int maxProfit(int[] prices){
        if(prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > dp[i - 1][1])
                dp[i][0] = prices[i] - dp[i - 1][1];
            else dp[i][0] = 0;
            dp[i][1] = Math.min(prices[i], dp[i - 1][1]);
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; ++i){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = dp[i - 1][0] - prices[i];
        }

        return dp[prices.length - 1][0];
    }

}
