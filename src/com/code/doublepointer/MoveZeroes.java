package com.code.doublepointer;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = -1, end = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++end;
                start = start == -1 ? 0 : start;
            } else {
                if (start == -1) continue;

                nums[start] = nums[i];
                nums[i] = 0;
                ++start;
                end = i;
            }
        }
    }
}
