package com.code.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        int maxLength = 0;
        for (Integer num : set){
              if (!set.contains(num - 1)){
                  int length = 1;
                  int temp = num;
                  while (set.contains(temp + 1)){
                      ++length;
                      ++temp;
                  };
                  maxLength = Math.max(length, maxLength);
              }
        }
        return maxLength;
    }

}
