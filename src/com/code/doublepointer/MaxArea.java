package com.code.doublepointer;

public class MaxArea {

    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int maxArea = 0;
        for (; start < end; ) {
            int length = end - start;
            int area = length * Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, area);
            if (height[start] < height[end]) {
                ++start;
            } else if (height[start] > height[end]) {
                --end;
            } else {
                ++start;
                --end;
            }
        }

        return maxArea;
    }
}
