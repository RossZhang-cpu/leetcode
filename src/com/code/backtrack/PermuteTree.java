package com.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteTree {
//    给定一个可包含重复数字的序列，返回所有不重复的全排列。
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        var list = new ArrayList<List<Integer>>();
        var temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        backTrack(nums, 0, list, temp);
        return list;
    }

    public void backTrack(int[] nums, int idx, List<List<Integer>> list, List<Integer> temp){
        if(idx == nums.length){
            list.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = 0; i < nums.length; ++i){
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i-1] )) continue;  //广度和深度的区别
            temp.add(nums[i]);
            vis[i] = true;
            backTrack(nums, idx + 1, list, temp);
            vis[i] = false;
            temp.remove(idx);
        }
    }
}
