package com.code.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target){
        if(n <= 2){
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
        }else{
            List<List<Integer>> result = new ArrayList<>();
            for(int i = start; i < nums.length; ++i){
                List<List<Integer>> temp = nSum(nums, n - 1, i + 1, target - nums[i]);
                for( List<Integer> sumList : temp)
                    sumList.add(nums[i]);
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) ++i;
                result.addAll(temp);
            }
            return result;
        }
    }

    public List<List<Integer>> nSumInput(int[] nums, int n, int target){
        if(nums == null || nums.length < n)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> lists = nSum(nums, n, 0, target);
        return lists;
    }

    public static void main(String[] args) {
        NSum sum = new NSum();
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        List<List<Integer>> lists = sum.nSumInput(nums, 4, 6);
        lists.forEach(System.out::println);
    }
}
