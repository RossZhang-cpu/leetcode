package com.code.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

//        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = {{1, 4}, {4, 5}};
        int[][] merge = new MergeIntervals().merge(ints);

        for(int i = 0; i < merge.length; ++i){
            String string = Arrays.toString(merge[i]);
            System.out.println(string);
        }
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < intervals.length; ++i){
            int low = intervals[i][0];
            int high = intervals[i][1];
            for(int j = i + 1; j < intervals.length; ++j){
                if(high < intervals[j][0]){     //无交集
                    i = j - 1 ;
                    break;
                }else{
                    i = j;
                    high = Math.max(intervals[j][1], high);
                }
            }
            int[] data = new int[]{low, high};
            result.add(data);
        }

       int[][] data = new int[result.size()][2];
       for(int i = 0; i < result.size(); ++i){
           data[i] = result.get(i);
       }
       return  data;
    }
}
