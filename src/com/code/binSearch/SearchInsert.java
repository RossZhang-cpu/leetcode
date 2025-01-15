package com.code.binSearch;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;

        int mid = 0;
        boolean found = false;
        while (left <= right) {
            mid = (left + right) / 2;

            if (target == nums[mid]) {
                found = true;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return found ? mid : left;

    }
}
