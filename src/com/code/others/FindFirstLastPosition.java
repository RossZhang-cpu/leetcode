package com.code.others;

public class FindFirstLastPosition {

    public int[] searchRange(int[] nums, int target) {
       int leftIdx = binarySearch(nums, target, true);
       int rightIdx = binarySearch(nums, target, false) - 1;
       if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target &&
       nums[rightIdx] == target){
           return new int[]{leftIdx, rightIdx};
       }
       return new int[]{-1, -1};
    }

    public  int binarySearch(int[] nums, int target, boolean lower){
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindFirstLastPosition firstLastPosition = new FindFirstLastPosition();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ints = firstLastPosition.searchRange(nums, target);
        for(int i : ints)
            System.out.println(i);
    }

}
