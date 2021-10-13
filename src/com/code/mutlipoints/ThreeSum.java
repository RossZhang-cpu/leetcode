package com.code.mutlipoints;

import java.util.*;
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        if(nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < nums.length; ++i) {
            List<List<Integer>> lists = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> twoSumList : lists)  //  如果找到结果，则添加
                twoSumList.add(nums[i]);
            if(lists != null && lists.size() > 0)
                result.addAll(lists);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) ++i;
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int start,  int target){
        if(nums.length < 2)
            return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int low = start;
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
                result.add(new ArrayList<>(integers));
                while(low < high && nums[low] == lo) ++low;
                while(low < high && nums[high] == hi) --high;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {1,1,1,2,2,3,4};
        List<List<Integer>> lists = threeSum.threeSum(nums, 6);
        lists.forEach(System.out::println);
    }
}
