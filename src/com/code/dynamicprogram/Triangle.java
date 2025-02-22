package com.code.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    /**
     * Given a triangle array, return the minimum path sum from top to bottom.
     *
     * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     *
     *
     *
     * Example 1:
     *
     * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * Output: 11
     * Explanation: The triangle looks like:
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
     * Example 2:
     *
     * Input: triangle = [[-10]]
     * Output: -10
     * @param triangle
     * @return
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int result;
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(triangle.get(0).get(0));
        int mininmum = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> list = new ArrayList<>();
            mininmum = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                List<Integer> lastRowResults = dp.get(i - 1);
                int lastNumIndex1 = Math.max(j - 1, 0);
                int lastNumIndex2 = Math.min(j, lastRowResults.size() - 1);
                int sum = triangle.get(i).get(j) + Math.min(lastRowResults.get(lastNumIndex1), lastRowResults.get(lastNumIndex2));
                list.add(sum);
                mininmum = Math.min(sum, mininmum);
            }
            dp.add(list);
        }
        return mininmum;
    }
}
