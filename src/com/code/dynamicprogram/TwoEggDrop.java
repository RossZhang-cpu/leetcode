package com.code.dynamicprogram;

import java.util.Arrays;

public class TwoEggDrop {

    /**
     * https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/?envType=daily-question&envId=2024-10-13
     * @param n
     * @return
     */
    private int[] memo = new int[1001];

    public int twoEggDrop(int n) {
        Arrays.fill(memo, -1);
        memo[0] = 0;

        int res = Integer.MAX_VALUE;
        int result = dfs(n, res);
        return result;
    }

    private int dfs(int n, int res) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        for (int i = 1; i <= n; ++i) {

            int times = Math.max(i, dfs(n - i, res) + 1);
            res = Math.min(res, times);
        }

        memo[n] = res;

        return res;

    }


}
