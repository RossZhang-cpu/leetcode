package com.code.dynamicprogram;

import java.util.Arrays;

public class SuperEggDrop {

    public static void main(String[] args) {
        SuperEggDrop drop = new SuperEggDrop();
        drop.superEggDrop(3, 26);
    }


    /**
     *给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     *
     * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
     *
     * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。
     * 如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
     *
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     *
     *
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }


        int res = dfs(k, n, Integer.MAX_VALUE, memo);

        for (int i = 0; i < memo.length; ++i) {
            for (int j = 0; j < memo[0].length; ++j) {
                System.out.print(memo[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("res is " + res);
        return res;

    }

    private int dfs(int k, int n, int result, int[][] memo) {
        if (k == 1) {
            return n;
        }
        if (n == 0 || k == 0) {
            return 0;
        }
        if (memo[k][n] != -1) {
            return memo[k][n];
        }



//        for(int i = 1; i <= n; ++i ) {
//            int leftRes = dfs(k - 1, i - 1, result, memo);
//            int rightRes = dfs(k, n - i, result, memo);
//            int curRes = Math.max(leftRes, rightRes) + 1;
////            System.out.printf("k is %d i is %d result is %s%n", k, i, result);
//
//            result = Math.min(curRes, result);
//
//        }
        int lo = 1;
        int hi = n;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int broken = dfs(k - 1, mid - 1, result, memo);
            int notBroken = dfs(k, n - mid, result, memo);
            if (broken > notBroken) {
                hi = mid - 1;
                result = Math.min(result, broken + 1);
            } else {
                lo = mid + 1;
                result = Math.min(result, notBroken + 1);
            }
        }



        memo[k][n] =result;
        return result;
    }
}
