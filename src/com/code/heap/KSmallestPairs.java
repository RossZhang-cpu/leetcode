package com.code.heap;

import java.util.*;
import java.util.stream.Collectors;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<Map.Entry<Integer, Integer>>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                int sum = nums1[i] + nums2[j];
                Map.Entry<Integer, Integer> entry = Map.entry(nums1[i], nums2[j]);
                map.computeIfAbsent(sum, key -> new ArrayList<>()).add(entry);
                set.add(sum);
            }
        }

        List<Integer> sortedList = set.stream().sorted().toList();
        List<List<Integer>> res = new ArrayList<>();
        for (Integer sum : sortedList) {
            List<Map.Entry<Integer, Integer>> entries = map.get(sum);
            for (Map.Entry<Integer, Integer> pair : entries) {
                res.add(List.of(pair.getKey(), pair.getValue()));
                --k;
                if (k == 0) break;
            }

            if (k == 0) break;
        }

        return res;
    }
}
