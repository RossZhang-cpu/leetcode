package com.code.slidingwindows;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {

            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
            if (i - deque.getFirst() >= k ) {
                deque.removeFirst();
            }

            if (i >= k - 1) {
                res[start] = deque.getFirst();
                ++start;
            }

        }
        return res;
    }
}
