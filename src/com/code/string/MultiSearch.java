package com.code.string;

import java.util.ArrayList;
import java.util.List;

public class MultiSearch {

    public int[][] multiSearch(String big, String[] smalls) {
        List<int[]> nextList = new ArrayList<>();
        for (String str : smalls) {
            int[] next = getNext(str);
            nextList.add(next);
        }

        int[][] res = new int[smalls.length][];
        for (int  si = 0; si < smalls.length; ++si) {
            String str = smalls[si];
            if (str.isEmpty()) {
                res[si] = new int[0];
                continue;
            }


            int[] next = nextList.get(si);
            int j = 0;
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < big.length(); ++i) {
                while (j > 0 && str.charAt(j) != big.charAt(i)) {
                    j = next[j - 1];
                }


                if (str.charAt(j) == big.charAt(i)) {
                    ++j;
                }

                if (j == str.length()) {
                    int index = i - j + 1;
                    positions.add(index);
                    j = 0;
                }
            }

            int[] tempPos = new int[positions.size()];
            res[si] = tempPos;
            for (int i = 0; i < tempPos.length; ++i) {
                tempPos[i] = positions.get(i);
            }
        }

        return res;
    }

    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        if (str.isEmpty()) {
            return next;
        }


        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); ++i) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j -1];
            }


            if (str.charAt(i) == str.charAt(j)) {
                ++j;
            }
            next[i] = j;
        }

        return next;

    }
}
