package com.code.math;

import java.util.Deque;
import java.util.LinkedList;

public class BigIntegerPlusOne {

    public int[] plusOne(int[] digits) {
        Deque<Integer> stack = new LinkedList<>();
        int preSum = 0;
        int temp = digits[digits.length - 1] + 1;
        stack.push(temp % 10);
        preSum = temp / 10;

        for (int i = digits.length - 2; i >= 0; --i) {
            temp = digits[i] + preSum;
            stack.push(temp % 10);
            preSum = temp / 10;
        }
        if (preSum > 0) stack.push(preSum);

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            ++i;
        }

        return res;

    }
}
