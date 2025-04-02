package com.code.dynamicprogram;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int[] minCost = new int[n];

        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i < n; ++i) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }

        return minCost[n - 1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs climbingStairs = new MinCostClimbingStairs();
        int[] test = {1,100,1,1,1,100,1,1,100,1};
        int i = climbingStairs.minCostClimbingStairs(test);
        System.out.println(i);

    }
}
