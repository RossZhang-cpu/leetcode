package com.code.doublepointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>(); // 创建一个空哈希表
        for (int j = 0; ; j++) { // 枚举 j
            int x = nums[j];
            // 在左边找 nums[i]，满足 nums[i]+x=target
            if (idx.containsKey(target - x)) { // 找到了
                return new int[]{idx.get(target - x), j}; // 返回两个数的下标
            }
            idx.put(x, j); // 保存 nums[j] 和 j
        }
    }


}
