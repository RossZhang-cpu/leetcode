package com.code.range;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }

        int toStart = newInterval[0];
        int toEnd = newInterval[1];

        List<int[]> list = new ArrayList<>();

        boolean findStart = false, findEnd = false;
        for (int i = 0; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];


            if (!findStart) {
                if (toStart < start) {
                    findStart = true;
                } else if (toStart <= end) {
                    toStart = start;
                    findStart = true;
                }
            }
            if (findStart && !findEnd) {
                if (toEnd < start) {
                    findEnd = true;
                } else if (toEnd <= end) {
                    toEnd = end;
                }

            }

            findEnd = (i == intervals.length - 1) || findEnd;

            if (!findStart) {
                list.add(new int[]{start, end});
            }

            if (findEnd && toStart <= toEnd) {
                list.add(new int[]{toStart, toEnd});
                toStart = Integer.MAX_VALUE;
            }

            if (findEnd && toEnd < start) {
                list.add(new int[]{start, end});
            }
        }


        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] range : list) {
            res[i++] = range;
        }


        return res;
    }
}


