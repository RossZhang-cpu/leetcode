package com.code.LinkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
/*
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
    public List<List<Integer>> subsets(int[] nums) {
        var list = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0){
            list.add(new LinkedList<Integer>());
            return list;
        }

        list.add(new LinkedList<Integer>());
        for(int i = 0 ; i < nums.length; ++i){
            int sizeBefore = list.size();
            for(int j = 0 ; j < sizeBefore; ++j){
                LinkedList<Integer> inList = new LinkedList<>(list.get(j));
                inList.addLast(nums[i]);
                list.add(new LinkedList<>(inList));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SubSets sets = new SubSets();
        System.out.println(sets.subsets(new int[]{1,2,3}));
    }
}
