package com.code.binary;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Roman2Integer {

    public int romanToInt(String s) {
        Map<Character, Integer> ramanToIntMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100,
                'D', 500, 'M', 1000);
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            char ch = array[i];
            Integer previous = stack.isEmpty() ? null : stack.pop();
            Integer cur = ramanToIntMap.get(ch);
            
            if (previous == null) {
                stack.push(cur);
            } else if (previous < cur) {
                result += cur - previous;
            } else {
                result += previous;
                stack.push(cur);
            }

            if (i == array.length - 1 && !stack.isEmpty()) {
                result  += stack.pop();
            }
            
        }
        return result;

    }
}
