package com.code.string;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        char[] array = strs[0].toCharArray();
        int end = array.length;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            end = Math.min(end, chars.length);
            for (int i = 0; i < chars.length; ++i) {
                if (i < end && chars[i] == array[i]) {
                    continue;
                } else {
                    end = Math.min(end, i);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < end; ++i) {
            sb.append(array[i]);
        }

        return sb.toString();
    }


}
