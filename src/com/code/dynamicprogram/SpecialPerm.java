package com.code.dynamicprogram;

import java.util.*;

public class SpecialPerm {
    /**
     *You are given a 0-indexed integer array nums containing n distinct positive integers. A permutation of nums is called special if:
     *
     * For all indexes 0 <= i < n - 1, either nums[i] % nums[i+1] == 0 or nums[i+1] % nums[i] == 0.
     * Return the total number of special permutations. As the answer could be large, return it modulo 109 + 7.
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,6]
     * Output: 2
     * Explanation: [3,6,2] and [2,6,3] are the two special permutations of nums.
     * Example 2:
     *
     * Input: nums = [1,4,3]
     * Output: 2
     * Explanation: [3,1,4] and [4,1,3] are the two special permutations of nums.
     */

//    public int specialPerm(int[] nums) {
//        /**
//         * require at least two numbers
//         * num[i] , num[i + 1]
//         *
//         * choose two numbers starts, and then dfs
//         *
//         *
//         *
//         */
//        Map<Integer, List<Map.Entry<Integer, Integer>>> map = new HashMap<>();
//
//        for(int i = 0; i < nums.length - 1; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
//                    List<Map.Entry<Integer, Integer>> list = map.getOrDefault(nums[i], new ArrayList<>());
//                    list.add(new AbstractMap.SimpleEntry<>(nums[i], nums[j]));
//                    map.put(nums[i], list);
//
//                    list = map.getOrDefault(nums[j], new ArrayList<>());
//                    list.add(new AbstractMap.SimpleEntry<>(nums[j], nums[i]));
//                    map.put(nums[j], list);
//                }
//            }
//        }
//
//        for (Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            int count = 1;
//            List<Map.Entry<Integer, Integer>> values = entry.getValue();
//            for (Map.Entry<Integer, Integer> pair : values) {
//                Integer value = pair.getValue();
//                ++count;
//                dfs(value, );
//            }
//
//        }
//
//    }
}