package com.code.binSearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length, mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (target >= nums[0]){
                if(nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else{
                if(nums[mid] >= nums[0])
                    nums[mid] = Integer.MIN_VALUE;
            }
            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
