package com.code.doublepointer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum2 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int first = 0; first < n; ++first ) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int third = n - 1;
            for (; second < third; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int sum = nums[first] + nums[second];
                if (sum + nums[third] < 0) {
                    break;
                }

                while (sum + nums[third] > 0 && third > second) {
                    --third;
                }

                if (third > second && sum + nums[third] == 0) {
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third]));
                    result.add(list);
                }
            }
        }

        return result;
    }


}
