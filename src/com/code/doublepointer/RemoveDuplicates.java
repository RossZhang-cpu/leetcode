package com.code.doublepointer;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i = removeDuplicates.removeDuplicates(new int[]{1,1, 2, 3});
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int start = 0;

        for(int i = 1; i < nums.length; ++i) {
            if (nums[start] != nums[i]) {
                int temp = nums[start + 1];
                nums[start + 1] = nums[i];
                nums[i] = temp;
                ++start;
            } else continue;
        }

        return start + 1;
    }
}
