package com.code.hash;

import java.util.*;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int current = num;
            int length = 1;
            while (set.contains(current + 1)) {
                ++current;
                ++length;
            }
            max = Math.max(length, max);
        }

        return max;


    }
}
