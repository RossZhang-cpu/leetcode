package com.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PerMute {
    public List<List<Integer>> permute(int[] nums) {
        var list = new ArrayList<List<Integer>>();
        var temp = new ArrayList<Integer>();
        backtrack(nums, list, temp);
        return list;
    }

    public void backtrack(int[] nums , List<List<Integer>> list,  List<Integer> temp){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(nums, list, temp);
            temp.remove((Object)nums[i]);
        }

    }

    public static void main(String[] args) {
        var list =new PerMute().permute(new int[]{1,2,3});
        System.out.println(list);
    }
}
