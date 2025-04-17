package com.code.dynamicprogram;

public class TrapRaining {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; ++i) {
            left[i] = i == 0 ? 0 : Math.max(height[i - 1], left[i - 1]);
        }

        for (int i = height.length - 1; i >= 0; --i) {
            right[i] = i == height.length - 1 ? 0 : Math.max(height[i + 1], right[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < height.length; ++i) {
            result += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }

        return result;

    }
}
