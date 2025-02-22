package com.code.slidingwindows;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = -1, sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            ++right;
            if (sum >= target) {
                while (sum - nums[left] >= target && left <= right) {
                    sum -= nums[left++];
                }
                minLen = Math.min(minLen, right - left + 1);
            }


        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;


    }
}
