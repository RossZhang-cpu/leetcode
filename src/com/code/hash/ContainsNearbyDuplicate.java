package com.code.hash;

import java.util.*;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int min = Math.min(nums.length - 1, k);
        HashSet<Integer> table = new LinkedHashSet<>(min);

        for (int i = 0; i <= min; ++i) {
            if (table.contains(nums[i])) {
                return true;
            } else {
                table.add(nums[i]);
            }
        }

        for (int idx = min + 1; idx < nums.length; ++idx) {
            table.remove(nums[idx - min - 1]);
            if (table.contains(nums[idx]))
                return true;
            else table.add(nums[idx]);
        }

        return false;

    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            if (!list.isEmpty()) {
                int tempI = i;
                Optional<Integer> any = list.stream().filter(v -> v >= (tempI - k) && v <= tempI).findAny();
                if (any.isPresent()) return true;
            }
            list.add(i);
            map.put(nums[i], list);
        }

        return false;

    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate duplicate = new ContainsNearbyDuplicate();
        duplicate.containsNearbyDuplicate2(new int[]{1,0,1,1}, 1);
    }
}
