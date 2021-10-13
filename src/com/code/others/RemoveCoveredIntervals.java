package com.code.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int cover = 0;
        for(int i = 1; i < intervals.length; ++i){
            if(left <= intervals[i][0] && right >= intervals[i][1])
                ++cover;
            else if((left <= intervals[i][0] && right < intervals[i][1]) || right < intervals[i][0]){
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - cover;
    }

    //区间合并
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a, b) ->{
           if(a[0] != b[0])
               return a[0] - b[0];
           return b[1] - a[1];
       } );

       List<List<Integer>> list = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();
       int left = intervals[0][0];
       int right = intervals[0][1];
       for(int i = 1; i < intervals.length; ++i){
           if(right >= intervals[1][0])     //可合并
               right = Math.max(intervals[1][1], right);
           else{
               temp.add(left);
               temp.add(right);
               list.add(temp);
               temp.clear();
               left = intervals[i][0];
               right = intervals[i][1];
           }
       }
       int[][] result = new int[list.size()][2];
       for(int i = 0; i < list.size(); ++i){
           result[i][0] = list.get(0).get(0);
           result[i][1] = list.get(0).get(1);
       }
       return result;
    }
}
