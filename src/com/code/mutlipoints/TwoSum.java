package com.code.mutlipoints;

import java.util.*;

public class TwoSum {
    public List<List<Integer>> twoSum(int[] nums, int target){
        if(nums.length < 2)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int sum = nums[low] + nums[high];
            int lo = nums[low];
            int hi = nums[high];
            if(sum < target){
                while(low < high && nums[low] == lo)
                    ++low;
            }else if(sum > target){
                while(low < high && nums[high] == hi)
                    --high;
            }else {
                List<Integer> integers = Arrays.asList(nums[low], nums[high]);
                result.add(integers);
                while(low < high && nums[low] == lo) ++low;
                while(low < high && nums[high] == hi) --high;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Queue<Integer> list = new LinkedList<>();
        TwoSum sum = new TwoSum();
        int[] nums = {-4, -1, -1, 0, 1, 3, 4};
        List<List<Integer>> lists = sum.twoSum(nums, 0);
        lists.forEach(System.out::println);
    }
}
