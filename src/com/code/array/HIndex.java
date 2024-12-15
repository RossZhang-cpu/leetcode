package com.code.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given an array of integers citations where citations[i]
 * is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the
 * maximum value of h such that the given researcher has published at least
 * h papers that have each been cited at least h times.
 */
public class HIndex {
    //sort [0,1,3,5,6]
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int maxH = 0;

        for (int i = 0; i < citations.length; ++i) {
            while (citations[i] >= h && citations.length - i >= h) {
                maxH = h;
                ++h;
            }

            if (citations.length - i < h) {
                break;
            }
        }

        return maxH;
    }


}
