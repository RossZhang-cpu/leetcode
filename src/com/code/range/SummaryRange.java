package com.code.range;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        int start = 0, end = 1;
        StringBuilder range = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (; end <= nums.length; ++end) {
            if (end != nums.length && (nums[end] == nums[end - 1] + 1)) {
                continue;
            }
            //find range
            if (end - start <= 1) {
                range.append(nums[start]);
            } else {
                range.append(nums[start]).append("->").append(nums[end - 1]);
            }
            list.add(range.toString());
            range = new StringBuilder();
            start = end;
        }
        return list;

    }
}
