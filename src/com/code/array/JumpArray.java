package com.code.array;

public class JumpArray {

    public int jump(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; ) {
            int step = nums[i];
            ++result;

            int max = i;
            int next = -1;
            if (max >= nums.length - 1) {
                break;
            }
            for (int j = 1; j <= step; ++j) {
                int lastIndex = Math.max(i + j, nums.length - 1);
                int maxPosition = nums[lastIndex] + lastIndex;
                if (maxPosition > max) {
                    next = i + j;
                    max = maxPosition;
                }
            }
            i = next;
        }

        return result;
    }
}
