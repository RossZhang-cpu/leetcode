package com.code.doublepointer;

public class TrapWater {

    public int trap(int[] height) {
        int left = 0, right = 0;
        int start = 0, end = height.length - 1;
        int res = 0;
        while (start <= end) {
            left = Math.max(height[start], left);
            right = Math.max(height[end], right);
            if (left <= right) {
                res += Math.max(0, left - height[start]);
                ++start;
            } else {
                res += Math.max(0, right - height[end]);
                --end;
            }

        }
        return res;
    }
}
