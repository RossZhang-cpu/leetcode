package com.code.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;


        char[] chars = s.toCharArray();
        int startIdx = 0, endIdx = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        for (; endIdx < chars.length; ++endIdx) {
            char ch = chars[endIdx];
            if (!map.containsKey(ch)) {
                map.put(ch, endIdx);
            } else {
                Integer index = map.get(ch);
                res = Math.max(res, map.size());
                while (startIdx <= index) {
                    map.remove(chars[startIdx++]);
                }
                startIdx = index + 1;
                map.put(ch, endIdx);
            }
        }
        res = Math.max(res, map.size());
        return res;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring(" ");
    }
}
