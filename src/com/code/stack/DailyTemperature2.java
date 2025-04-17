package com.code.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperature2 {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        //>= pop then push  < push
        for (int i = temperatures.length - 1; i >= 0; --i ) {
            while (!stack.isEmpty()) {
                Integer index = stack.peek();
                if (temperatures[i] >= temperatures[index]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            ans[i] = stack.isEmpty() ? 0 : stack.pop() - i;
            stack.push(i);
        }

        return ans;
    }
}
