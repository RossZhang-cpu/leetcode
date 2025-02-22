package com.code.heap.topK;

import java.util.Arrays;
import java.util.Collections;

public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0, right = nums[len - 1] - nums[0];

        while (left <= right) {
            int mid = (left + right) >>> 2;
            if (calculate(nums, mid) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int calculate(int[] nums, int mid) {
        int count = 0;
        int j = 1;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                ++j;
            }
            count += j - 1 - i;
        }

        return count;
    }
}
