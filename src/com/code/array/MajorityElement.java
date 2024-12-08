package com.code.array;

import java.util.Arrays;

public class MajorityElement {
    /**
     * <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //ToDO: quick sort
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        return nums[(low + high) / 2];

    }

    public static void main(String[] args) {

    }

    public static <T1, T2, T4, T3> T3 returnTypeGeneric(T1 val1, T2 val2, T4 val3) {

        return null;

    }
}
