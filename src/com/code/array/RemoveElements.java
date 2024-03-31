package com.code.array;

public class RemoveElements {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int i =0;
        for (int j = nums.length - 1; j > i; --j) {
            if (nums[j] != val) {
                while(i < j && nums[i] != val) {
                    ++i;
                }
                if (i == j) {
                    break;
                }else {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    ++i;
                }
            }
        }
        if (nums[i] != val) ++i;
        return i;

    }

}
